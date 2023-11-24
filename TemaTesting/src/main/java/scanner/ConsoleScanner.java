package scanner;

import units.*;

import java.util.Scanner;

public class ConsoleScanner {

    private final Scanner sc;
    private final String[] metricUnitsSymbols;

    public ConsoleScanner() {
        this.sc =new Scanner(System.in);
       this.metricUnitsSymbols =new String[]{"mm","cm","dm","m","km"};
    }

    public ConsoleScanner(Scanner sc,String[]metricUnitsSymbols) {
       this.sc = sc;
       this.metricUnitsSymbols = metricUnitsSymbols;
   }



   public void verifyMetricUnits(String readValue){
       for(String verify:metricUnitsSymbols){
           if(readValue.equals(verify)){
              return;
          }
       }
       System.err.println("You didn't write a valid format");
    }

    public String readLine(){
      return sc.nextLine();
    }
//    }
    public MetricUnits choseInstances(String symbol){
        switch (symbol){
            case"mm":return new MilimeterUnit();

            case"cm":return new CentimeterUnit();

            case"dm":return new DecimeterUnit();

            case"m":return new MeterUnit();

            case "km":return new KilometerUnit();


        }
        return null;
    }
}
