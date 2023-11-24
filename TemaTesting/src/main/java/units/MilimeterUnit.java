package units;

public class MilimeterUnit extends MetricUnits {

    public MilimeterUnit() {
        super(0.001, "mm");
    }
    public double transformValue(String symbol,double userValue){
        return userValue;
    }
}
