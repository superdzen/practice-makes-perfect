package com.superdzen.codeforces_118a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by superdzen@gmail.com on 01.07.2017.
 * http://codeforces.com/problemset/problem/118/A
 * Петя записался в кружок по программированию. На первом занятии Пете задали написать простую программу.
 * Программа должна делать следующее: в заданной строке, которая состоит из прописных и строчных латинских букв, она:
 * удаляет все гласные буквы,
 * перед каждой согласной буквой ставит символ ".",
 * все прописные согласные буквы заменяет на строчные.
 * Гласными буквами считаются буквы "A", "O", "Y", "E", "U", "I", а согласными — все остальные.
 * На вход программе подается ровно одна строка, она должна вернуть результат в виде одной строки, получившейся после обработки.
 * Помогите Пете справиться с этим несложным заданием.
 * Входные данные:
 * Первая строка представляет собой входные данные для Петиной программы.
 * Эта строка состоит только из прописных и строчных латинских букв и имеет длину от 1 до 100 включительно.
 * Выходные данные:
 * Выведите получившуюся строку. Гарантируется, что эта строка не пуста.
 */
public class Solution118A {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();
        inputString = inputString.toLowerCase().replaceAll("[aeioyu]", "");
        for (int i = 0; i < inputString.length(); i++) {
            stringBuilder.append(".");
            stringBuilder.append(inputString.charAt(i));
        }
        System.out.println(stringBuilder.toString());
        bufferedReader.close();
    }
}