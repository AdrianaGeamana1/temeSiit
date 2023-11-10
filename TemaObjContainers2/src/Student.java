import java.util.List;

public class Student extends Person{
    public Student(String name, int age,List<Hobby>hobbyList) {
        super(name, age,hobbyList);
    }
    public Student(String name,int age){
        super(name,age);
    }
    @Override
    public String toString() {
        return "Student{"+
                "name='"+getName()+
                "age='"+getAge()+'\'';
    }
}
