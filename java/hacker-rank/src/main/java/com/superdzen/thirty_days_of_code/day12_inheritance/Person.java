package com.superdzen.thirty_days_of_code.day12_inheritance;

/**
 * Created by superdzen@gmail.com on 04.07.2017.
 * 
 */
class Person {
    private String firstName;
    private String lastName;
    private int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }
}
