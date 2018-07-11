package com.superdzen.data_structures.java_stack;

import java.util.*;

/**
 * Created by superdzen@gmail.com on 15.07.2017.
 * https://www.hackerrank.com/challenges/java-stack
 * A string containing only parentheses is balanced if the following is true:
 * 1. if it is an empty string
 * 2. if A and B are correct, AB is correct,
 * 3. if A is correct, (A) and {A} and [A] are also correct.
 * Given a string, determine if it is balanced or not.
 */
public class JavaStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            if (input.length() == 0) {
                System.out.println("true");
            } else {
                System.out.println(isBalanced(input));
            }
        }
        sc.close();
    }

    private static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty()) {
                switch (str.charAt(i)) {
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        }
                        break;
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        break;
                    default:
                        stack.push(str.charAt(i));
                }

            } else {
                stack.push(str.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}