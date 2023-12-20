package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static Logger logger;

    static {
    //    System.setProperty("java.util.logging.config.file","src/main/java/org/example/logging.properties");

        logger = Logger.getLogger(App.class.getName());
    }

    public static void main(String[] args) {
        logger.info("start app");
       try {
            StudentRepository sr = new StudentRepository("resources/actualstudentsfile.csv", "resources/archivestudentsfile.csv","resources/studentsbyagefile.csv");
          //  StudentRepository sr = new StudentRepository("resourc/actualstudentsfile.csv", "resources/archivestudentsfile.csv");
            sr.saveStudents("1234567891234", "ale", "borod", "07/06/1990", "F");
            sr.saveStudents("4567891234567", "adri", "borod", "07/06/1989", "f");
            sr.saveStudents("7653219876543", "alex", "butea", "07/06/1990", "M");
            sr.saveStudents("8765432198765", "vio", "heredea", "05/08/2000", "M");
            sr.saveStudents("2345678964", "silviu", "darastean", "05/08/2000", "M");
            sr.deleteStudent("2345678965437");
            sr.listStudentsByLastName();
            System.out.println("--------------------------------");
            sr.listStudentsByBirthDate();
            System.out.println("-------------------------");
            sr.retrieveAllStudentsOfAgeX("33");
       } catch (Exception e){
          logger.log(Level.SEVERE,"Error during run",e);

       }
        logger.info("end app");
    }
}




