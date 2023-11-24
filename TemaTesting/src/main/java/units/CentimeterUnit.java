package units;

import units.MetricUnits;

public class CentimeterUnit extends MetricUnits {
    public CentimeterUnit() {
        super(0.01, "cm");
    }
    public double transformValue(String symbol,double userValue){
        if(symbol.equals("mm")){
            return userValue*10;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
