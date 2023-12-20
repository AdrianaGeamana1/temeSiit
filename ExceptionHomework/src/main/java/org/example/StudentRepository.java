package org.example;

//import com.sun.media.sound.InvalidDataException;
//import com.sun.tools.example.debug.tty.LineNotFoundException;

import javax.sound.sampled.DataLine;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRepository {
    private static Logger logger2;

    static {

        logger2 = Logger.getLogger(StudentRepository.class.getName());
    }
   private String pathFile;
   private String pathArchive;
   private String pathToAgeFile;
   private List<String> actualStudentsStringList;
   private List<Student>actualStudentList;
   private ValidationClass validationClass;
   private BufferedWriter out=null;
   private BufferedWriter out2=null;

    public StudentRepository(String pathFile, String pathArchive,String pathToAgeFile) {
        this.pathFile = pathFile;
        this.pathArchive = pathArchive;
        this.pathToAgeFile=pathToAgeFile;
        this. actualStudentsStringList =new ArrayList<>();
        this.actualStudentList=new ArrayList<>();
        this. validationClass=new ValidationClass();

    }
    public void saveStudents(String cnp,String firstName,String lastName,String dateOfBirth,String genderSymbol) {
        logger2.info("start save student");
        try {validationClass.verifyCnp(cnp);
            validationClass.verifyFirstName(firstName);
            validationClass.verifyLastName(lastName);
            validationClass.verifyDateOfBirth(dateOfBirth);
            String genderSymbol2=validationClass.verifyGender(genderSymbol);
            String row = cnp + "," + firstName + "," + lastName + "," + dateOfBirth + "," + genderSymbol2;
            this.writeRow(row);
            this.writeRowToArchive(row);
        }catch (IllegalArgumentException e) {
            logger2.log(Level.SEVERE, e.getMessage(), e);
        }
        logger2.info("end of saving student");
    }

    public void deleteStudent(String id) {
        logger2.info("start delete student");
        boolean flag=false;
        try (BufferedReader in = new BufferedReader(new FileReader(pathFile)))
        {  String line;
            while ((line = in.readLine()) != null) {
                String[] tokens6 = line.split(",");
                boolean c1 =validationClass.verifyCnp(id);
                boolean c2= validationClass.verifyCnp(tokens6[0]);
                if (tokens6[0].equals(id)) {
                    flag=true;
                    continue;
                } else {
                    actualStudentsStringList.add(line);
                }
            }
            if(!flag){
                throw new IllegalArgumentException("The student you want to delete doesn't exist in the file");
            }
            new FileWriter(pathFile, false).close();
            for (String l : actualStudentsStringList) {
                System.out.println(l);
                this.writeRow(l);
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("the name of the file is not correct or the file is not existing",e);
        }catch(IOException e) {
            throw new RuntimeException("a line from the file cannot be read",e);
        }catch (IllegalArgumentException e)  {
            logger2.log(Level.WARNING,e.getMessage(),e);
        } catch(IndexOutOfBoundsException e){
            throw new RuntimeException("Error from actualStudentStringList",e);
        }
        logger2.info("end of deleting student");
    }

    void writeRow(String row) {
        try {
            out = new BufferedWriter(new FileWriter(pathFile,true));
            out.write(row+"\n");
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("the name of the file in witch you want to write students is not correct or does not exist",e);
        }
    }
    void writeRowToArchive(String row) {
        try {
            out2 = new BufferedWriter(new FileWriter(pathArchive,true));
            out2.write(row+"\n");
            out2.flush();
        } catch (IOException e) {
            throw new RuntimeException("the name of the archiveFile in witch you want to write students is not correct or does not exist",e);
        }
    }
    void writeRowToAgeFile(String row) {
        try {
            out = new BufferedWriter(new FileWriter(pathToAgeFile,true));
            out.write(row+"\n");
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("the name of the file in witch you want to write students by ageX is not correct or does not exist",e);
        }
    }

    public void retrieveAllStudentsOfAgeX(String ageX){
        logger2.info("start retrieve students by "+ageX);
        try (BufferedReader in = new BufferedReader(new FileReader(pathFile))) {
            int age2 = validationClass.verifyIfAgeIsNumber(ageX);
            validationClass.verifyIfAgeIsNegative(age2);
            new FileWriter(pathToAgeFile, false).close();
            String readLine;
            while ((readLine = in.readLine()) != null) {
                String[] tokens5 = readLine.split(",");
                if (Student.calculateAge(tokens5[3]) == age2) {
                    System.out.println(tokens5[0] + " " + tokens5[1] + " " + tokens5[2] + " " + tokens5[3] + " " + tokens5[4]);
                    String rowToAgeFile=tokens5[0] + "," + tokens5[1] + "," + tokens5[2] + "," + tokens5[3] + "," + tokens5[4];
                    this.writeRowToAgeFile(rowToAgeFile);
                }
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("Nu exista/nu s-a gasit fisierul de citit pentru a calcula varsta studentilor",e);
        }catch (IllegalArgumentException e){
            logger2.log(Level.SEVERE,e.getMessage(),e);
        }catch (IOException e){
            throw new RuntimeException("Nu s-a putut citi linia din fisier pt a calcula varsta",e);
        }
        logger2.info("ending retrieve students by "+ageX);
    }
    public void listStudentsByLastName(){
        logger2.info("start sorting students by last name");
        try(BufferedReader in2=new BufferedReader(new FileReader(pathFile))){
            String lineToRead;
            while ((lineToRead=in2.readLine())!=null){
                String[]tokens8=lineToRead.split(",");
                validationClass.verifyLastName(tokens8[2]);
                actualStudentList.add(new Student(tokens8[0],tokens8[1],tokens8[2],tokens8[3],Gender.valueOf(tokens8[4])));

            }
            LastNameComparator lastNameComparator=new LastNameComparator();
            Collections.sort(actualStudentList,lastNameComparator);
            new FileWriter(pathFile, false).close();
            for(Student s:actualStudentList){
                System.out.println(s.getCnp()+" "+s.getFirstName()+" "+s.getLastName()+" "+s.getDateOfBirth()+" "+s.getGender().getName());
                String row2=s.getCnp()+","+s.getFirstName()+","+s.getLastName()+","+s.getDateOfBirth()+","+s.getGender().getName();
                this.writeRow(row2);
            }
            actualStudentList.clear();
        }catch(FileNotFoundException e){
            throw new RuntimeException("nu s-a gasit fisierul cu studenti pt sortarea dupa lastName",e);
        }catch(IOException e){
            throw new RuntimeException("nu s-a putut citi linia pt sortarea studentilor dupa lastName",e);
        }catch (IllegalArgumentException e){
            logger2.log(Level.SEVERE,e.getMessage(),e);
        }
        logger2.info("Ending sorting students by last name");


    }

    public void listStudentsByBirthDate() {
        logger2.info("start sorting student by Birth Date");
        try (BufferedReader in3 = new BufferedReader(new FileReader(pathFile))) {
            String lineToRead2;
            while ((lineToRead2 = in3.readLine()) != null) {
                String[] tokens9 = lineToRead2.split(",");
                validationClass.verifyDateOfBirthIsEmpty(tokens9[3]);
                actualStudentList.add(new Student(tokens9[0], tokens9[1], tokens9[2], tokens9[3], Gender.valueOf(tokens9[4])));

            }
            DateOfBirthComparator dateOfBirthComparator = new DateOfBirthComparator();
            Collections.sort(actualStudentList, dateOfBirthComparator);
            new FileWriter(pathFile, false).close();
            for (Student s : actualStudentList) {
                System.out.println(s.getCnp() + " " + s.getFirstName() + " " + s.getLastName() + " " + s.getDateOfBirth() + " " + s.getGender().getName());
                String row3 = s.getCnp() + "," + s.getFirstName() + "," + s.getLastName() + "," + s.getDateOfBirth() + "," + s.getGender().getName();
                this.writeRow(row3);
            }
            actualStudentList.clear();
        }catch(FileNotFoundException e){
            throw new RuntimeException("nu s-a gasit fisierul cu studenti pt sortarea dupa data de nastere",e);
        }catch(IOException e){
            throw new RuntimeException("nu s-a putut citi linia pt sortarea dupa data de nastere",e);
        }catch (IllegalArgumentException e){
            logger2.log(Level.SEVERE,e.getMessage(),e);
        }
        logger2.info("Ending sorting students by birth date");
    }

}
