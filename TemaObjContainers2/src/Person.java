import java.util.List;

public abstract class Person {
    private String name;
    private int age;

    private List<Hobby>hobbyList;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;


    }
    public Person(String name,int age,List<Hobby>hobbyList){
        this.name=name;
        this.age=age;
        this.hobbyList=hobbyList;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public List<Hobby> getHobbyList(){
        return hobbyList;
    }

    @Override
    public String toString() {
        return "Person{"+
                "name='"+getName()+
                "age='"+getAge()+
                "hobbies'"+getHobbyList()+'\'';
    }

    @Override
    public boolean equals(Object obj) {
        Person other=(Person)obj;
        return this.getName().equals(other.getName())&&this.getAge()==other.getAge();
    }

    @Override
    public int hashCode() {
        int result=0;
        result= result+(getName() != null ? getName().hashCode() : 0);
        result=result+(getAge()!=0?(int)getAge()*31:0);
        return result;
    }
    }

