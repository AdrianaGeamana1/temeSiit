package scales;

public abstract class Scales {
    String name;

    public Scales() {
    }

    public Scales(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
