package org.example;

public class ValidationClass {

    public boolean verifyCnp(String cnp)throws IllegalArgumentException{
       if(cnp.isEmpty()||cnp.length()!=13) {
           throw new IllegalArgumentException("cnp should be exactly 13 digits long");
       }
       return true;
    }
    public boolean verifyFirstName(String firstName)throws IllegalArgumentException{
        if(firstName.isEmpty()){
            throw new IllegalArgumentException("first name should not be empty");
        }
        return true;
    }
    public boolean verifyLastName(String lastName)throws IllegalArgumentException{
        if(lastName.isEmpty()){
            throw new IllegalArgumentException("last name should not be empty");
        }
        return true;
    }
    public boolean verifyDateOfBirthIsEmpty(String dateOfBirth)throws IllegalArgumentException{
        if(dateOfBirth.isEmpty()){
            throw new IllegalArgumentException("date of birth should not be empty");
        }
        return true;
    }
    public boolean verifyDateOfBirth(String dateOfBirth)throws IllegalArgumentException{
        String[]strings=dateOfBirth.split("/");
        int year=parseInt(strings[2]);
        if(year<1900||year>(2023-18)){
            throw new IllegalArgumentException("the year must be between 1900 and 2015");
        }
       return true;
    }
    private static int parseInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Token-ul: [" + token + "] nu s-a putut converti la int", e);
        }
    }
    public String verifyGender(String genderSymbol)throws IllegalArgumentException{
        boolean flag=false;
        String genderSymbol2=genderSymbol.toUpperCase();
        Gender[]values=Gender.values();
        for(Gender gender:values){
            if(gender.getName().equals(genderSymbol2)){
                flag=true;
            }
        }
      if(!flag) {
          throw new IllegalArgumentException("The gender symbol must be F,M,f,m");
      }
       return genderSymbol2;
    }
    public int verifyIfAgeIsNumber(String age){
        try{
            return Integer.parseInt(age);
        }catch (NumberFormatException e){
           throw new RuntimeException("AGE must be a number",e);
        }
    }
    public int verifyIfAgeIsNegative(int age)throws IllegalArgumentException{
         if(age<0){
             throw new IllegalArgumentException("age cannot be negative");
         }
         return age;
    }
}
