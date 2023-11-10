import java.util.List;

public class Hobby {
    private String hobbyName;
    private int frequency;
    private List<Address> adressList;

    public Hobby(){

    };
    public Hobby(String hobbyName, int frequency, List<Address> adressList) {
        this.hobbyName = hobbyName;
        this.frequency = frequency;
        this.adressList = adressList;

    }
    public String getHobbyName(){
        return hobbyName;
    }
    public int getFrequency(){
        return frequency;
    }
    public List<Address> getAddressList(){
        return adressList;
    }

    @Override
    public String toString() {
        return "Hobby{"+
                "name='"+getHobbyName()+
                "frequency='"+getFrequency()+
                "address'"+getAddressList()+'\'';
    }
    @Override
    public boolean equals(Object obj) {
        Hobby other=(Hobby) obj;
        return this.getHobbyName().equals(other.getHobbyName());
    }
    @Override
    public int hashCode() {
        int result=0;
        result= result+(getHobbyName() != null ? getHobbyName().hashCode() : 0);
        return result;
    }
}
