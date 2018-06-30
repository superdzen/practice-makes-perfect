package com.superdzen.chat.network;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by superdzen@gmail.com on 02.06.2018.
 */
public class TCPConnection {

    private final Socket socket;
    private final Thread rxThread;
    private final ITCPConnectionListener eventListener;
    private final BufferedReader in;
    private final BufferedWriter out;

    // Constructor for TCP connection with new Socket
    public TCPConnection(ITCPConnectionListener eventListener, String ipAddr, int port) throws IOException {
        this(eventListener, new Socket(ipAddr, port));
    }

    // Constructor for TCP connection by existing Socket object
    public TCPConnection(ITCPConnectionListener eventListener, Socket socket) throws IOException {
        this.socket = socket;
        this.eventListener = eventListener;
        // Get input and output stream for Socket. We are going to read string by string
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8")));

        // Create new Thread for listening incoming connections
        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Say to Listener that TCP connection is ready
                    eventListener.onConnectionReady(TCPConnection.this);
                    // Read messages while Thread is not interrupted
                    while (!rxThread.isInterrupted()) {
                        String msg = in.readLine();
                        // Give the message to Listener for processing
                        eventListener.onReceiveString(TCPConnection.this, msg);
                    }
                } catch (IOException e) {
                    eventListener.onException(TCPConnection.this, e);
                } finally {
                    eventListener.onDisconnect(TCPConnection.this);
                }
            }
        });
        rxThread.start();
    }

    // Send String data into the TCP connection. Synchronized for using from different threads
    public synchronized void sendString(String value) {
        try {
            // Add EOL symbols and flush the output buffer
            out.write(value + "\r\n");
            out.flush();
        } catch (IOException e) {
            eventListener.onException(TCPConnection.this, e);
            disconnect();
        }
    }

    // Disconnect the connection. Synchronized for using from different threads
    public synchronized void disconnect() {
        rxThread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onException(TCPConnection.this, e);
        }
    }

    @Override
    public String toString() {
        return "TCPConnection " + socket.getInetAddress() + ":" + socket.getPort();
    }
}