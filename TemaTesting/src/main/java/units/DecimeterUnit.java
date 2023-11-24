package units;

import units.MetricUnits;

public class DecimeterUnit extends MetricUnits {
    public DecimeterUnit() {
        super(0.1, "dm");
    }

    public double transformValue(String symbol, double userValue) {
        switch (symbol) {
            case "cm":
                return userValue * 10;
            case "mm":
                return userValue * 100;

        }
        return 0;
    }
}
