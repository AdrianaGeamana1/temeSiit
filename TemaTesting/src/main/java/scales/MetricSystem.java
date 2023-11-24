package scales;

public class MetricSystem {
    private final Scales[] scales;

    public MetricSystem() {
        this.scales=new Scales[]{new LengthScale(),new LiquidVolumeScale(),new MassScale()};
    }

    public MetricSystem(Scales[] scales) {
        this.scales = scales;
    }
}
