package org.example;

/**
 * Hello world!
 *
 */
public class App{


    public static void main(String[] args )throws Exception
    {
        FinalStandingCalculator finalStandingCalculator=new FinalStandingCalculator();
        finalStandingCalculator.parsingInput("resources/athletsresults.csv");
        finalStandingCalculator.printFinalResults();
    }
}
