import java.util.List;

public class Unemployed extends Person {
    public Unemployed(String name, int age) {
        super(name, age);
    }
    public Unemployed(String name, int age, List<Hobby> hobbyList) {
        super(name, age,hobbyList);
    }
    @Override
    public String toString() {
        return "Unemployed{"+
                "name='"+getName()+
                "age='"+getAge()+'\'';
    }
}
