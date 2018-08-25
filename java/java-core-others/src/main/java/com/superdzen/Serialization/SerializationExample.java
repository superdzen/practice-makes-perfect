package com.superdzen.Serialization;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created by superdzen@gmail.com on 13.11.2017.
 */
public class SerializationExample {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Vasya", new BigDecimal(40000));
        Employee employee1 = null;

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Employee.ser"));) {
            objectOutputStream.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employee.ser"));) {
            employee1 = (Employee) objectInputStream.readObject();
            System.out.println(employee1.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
