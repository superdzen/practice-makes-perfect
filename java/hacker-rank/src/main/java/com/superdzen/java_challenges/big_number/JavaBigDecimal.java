package com.superdzen.java_challenges.big_number;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 12.07.2017.
 * https://www.hackerrank.com/challenges/java-bigdecimal
 * Sorting of BigDecimal Numbers using Comparator
 */
public class JavaBigDecimal {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                BigDecimal a = new BigDecimal(s1);
                BigDecimal b = new BigDecimal(s2);
                return b.compareTo(a);
            }
        };

        Arrays.sort(s, 0, n, comparator);
        sc.close();
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}

