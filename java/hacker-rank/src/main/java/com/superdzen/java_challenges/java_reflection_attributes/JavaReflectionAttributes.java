package com.superdzen.java_challenges.java_reflection_attributes;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by superdzen@gmail.com on 10.08.2017.
 * https://www.hackerrank.com/challenges/java-reflection-attributes
 */
public class JavaReflectionAttributes {

    public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        List<String> methodList = new ArrayList<>();
        for (Method method : methods) {
            methodList.add(method.getName());
        }

        Collections.sort(methodList);

        for (String methodName : methodList) {
            System.out.println(methodName);
        }
    }

}
