package scales;

import scales.Scales;
import units.*;

public class LengthScale extends Scales {
    private final MetricUnits[] metricUnits;


    public LengthScale() {
        super("Length Scale");
        this.metricUnits=new MetricUnits[]{new MeterUnit(),new KilometerUnit(),new MilimeterUnit(),new CentimeterUnit(),new DecimeterUnit()};
    }

    public LengthScale( MetricUnits[] metricUnits) {
        super("Length Scale");
        this.metricUnits = metricUnits;
    }
}
