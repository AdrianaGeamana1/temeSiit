package units;

import units.MetricUnits;

public class MeterUnit extends MetricUnits {
    public MeterUnit() {
        super(1.0, "m");
    }
    public double transformValue(String symbol,double userValue){
        switch (symbol){
            case"dm": return userValue*10;
            case"cm": return userValue*100;
            case"mm": return userValue*1000;
        }
        return 0;
    }
}
