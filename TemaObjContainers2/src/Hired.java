import java.util.List;

public class Hired extends Person{
    public Hired(String name, int age) {
        super(name, age);
    }
    public Hired(String name, int age, List<Hobby> hobbyList) {
        super(name, age,hobbyList);
    }
    @Override
    public String toString() {
        return "Hired{"+
                "name='"+getName()+
                "age='"+getAge()+'\'';
    }
}
