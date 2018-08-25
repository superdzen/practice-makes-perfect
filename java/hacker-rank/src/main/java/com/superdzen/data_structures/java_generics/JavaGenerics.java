package com.superdzen.data_structures.java_generics;

import java.lang.reflect.Method;

/**
 * Created by superdzen@gmail.com on 08.07.2017.
 *
 */
@SuppressWarnings("SyntaxError")
public class JavaGenerics {
    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)//noinspection SyntaxError
            System.out.println("Method overloading is not allowed!");

    }
}
class Printer
{
    <T> void printArray(T[] array){
        for (T elem : array) {
            System.out.println(elem);
        }
    }
}