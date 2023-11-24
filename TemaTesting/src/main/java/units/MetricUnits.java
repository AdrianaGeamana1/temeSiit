package units;

public abstract class MetricUnits {
    private double value;
    private String nameSymbol;

    public MetricUnits() {
    }

    public MetricUnits(double value, String nameSymbol) {
        this.value = value;
        this.nameSymbol = nameSymbol;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setNameSymbol(String nameSymbol) {
        this.nameSymbol = nameSymbol;
    }

    public double getValue() {
        return value;
    }
    public String getNameSymbol(){
        return nameSymbol;
    }
     public abstract double transformValue(String symbol,double userValue);

    @Override
    public String toString() {
        return "MetricUnits{" +
                "value=" + value +
                ", nameSymbol='" + nameSymbol + '\'' +
                '}';
    }
}
