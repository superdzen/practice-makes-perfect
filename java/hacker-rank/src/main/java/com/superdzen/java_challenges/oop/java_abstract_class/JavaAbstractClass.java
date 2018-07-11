package com.superdzen.java_challenges.oop.java_abstract_class;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 30.09.2017.
 * https://www.hackerrank.com/challenges/java-abstract-class
 */

abstract class Book {
    String title;

    abstract void setTitle(String title);

    String getTitle() {
        return title;
    }
}

class MyBook extends Book {

    @Override
    void setTitle(String s) {
        this.title = s;
    }
}

public class JavaAbstractClass {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: " + new_novel.getTitle());
        sc.close();
    }
}
