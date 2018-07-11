package com.superdzen.simplechat;

/**
 * Created by superdzen@gmail.com on 03.06.2018.
 */
public interface ITCPConnectionListener {
    void onConnectionReady(TCPConnection tcpConnection);

    void onReceiveString(TCPConnection tcpConnection, String value);

    void onDisconnect(TCPConnection tcpConnection);

    void onException(TCPConnection tcpConnection, Exception e);
}
