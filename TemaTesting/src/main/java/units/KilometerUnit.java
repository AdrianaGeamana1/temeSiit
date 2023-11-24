package units;

import units.MetricUnits;

public class KilometerUnit extends MetricUnits {
    public KilometerUnit() {
        super(1000.0, "km");
    }
    public double transformValue(String symbol,double userValue){
        switch (symbol){
            case "m":return userValue*1000;
            case "dm":return userValue*10000;
            case "cm":return userValue*100000;
            case "mm":return userValue*1000000;
        }
        return 0;
    }
}
