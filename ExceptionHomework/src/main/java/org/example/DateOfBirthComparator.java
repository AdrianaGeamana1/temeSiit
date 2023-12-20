package org.example;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        String[]tokens=o1.getDateOfBirth().split("/");
        String[]tokens2=o2.getDateOfBirth().split("/");
        if((tokens[2].compareTo(tokens2[2]))==0){
            if((tokens[1].compareTo(tokens2[1]))==0){
                return tokens[0].compareTo(tokens2[0]);
            }
            return tokens[1].compareTo(tokens2[1]);
        }
        return tokens[2].compareTo(tokens2[2]);
    }
}
