
import java.util.*;

public class Main {
    public static void main(String[] args) {
    NameComparator nameComparator=new NameComparator();
    AgeComparator ageComparator=new AgeComparator();
        Comparator<Person> nameAndAge = nameComparator.thenComparing(ageComparator);
        Set<Person>personSet=new TreeSet<>(nameAndAge);
        personSet.add(new Student("Florin",23));
        personSet.add(new Hired("Alexandra",40));
        personSet.add(new Hired("Alexandra",19));
        personSet.add(new Unemployed("Mirela",20));
        //prima metoda de iterare
        for (Person person:personSet){
            System.out.println(person.getName()+" "+person.getAge());
        }
        System.out.println();
        //a doua metoda de iterare
        Iterator<Person>setIterator=personSet.iterator();
        while(setIterator.hasNext()){
            System.out.println(setIterator.next());

        }
        System.out.println();

        //a doua parte a temei
        List<Country>countryList1=new ArrayList<>();
        countryList1.add(new Country("Brazilia"));
        countryList1.add(new Country("Venezuela"));
        countryList1.add(new Country("Argentina"));

        List<Country>countryList2=new ArrayList<>();
        countryList2.add(new Country("Romania"));
        countryList2.add(new Country("Franta"));
        countryList2.add(new Country("Spania"));

        List<Country>countryList3=new ArrayList<>();
        countryList2.add(new Country("Olanda"));
        countryList2.add(new Country("Franta"));
        countryList2.add(new Country("Anglia"));

        List<Country>countryList4=new ArrayList<>();
        countryList2.add(new Country("Japonia"));
        countryList2.add(new Country("Filipine"));
        countryList2.add(new Country("Maldive"));

        List<Country>countryList5=new ArrayList<>();
        countryList5.add(new Country("Rusia"));
        countryList5.add(new Country("Cambodgia"));
        countryList5.add(new Country("Turcia"));

        List<Address>addressList1=new ArrayList<>();
        addressList1.add(new Address("America de Sud",countryList1));
        addressList1.add(new Address("Europa",countryList2));

        List<Address>addressList2=new ArrayList<>();
        addressList2.add(new Address("Europa",countryList3));
        addressList2.add(new Address("Asia",countryList4));

        List<Address>addressList3=new ArrayList<>();
        addressList3.add(new Address("Europa",countryList3));
        addressList3.add(new Address("Asia",countryList5));

        List<Address>addressList4=new ArrayList<>();
        addressList3.add(new Address("Europa",countryList3));
        addressList3.add(new Address("Asia",countryList5));
        addressList3.add(new Address("America de Sud",countryList1));

        Hobby hobby1=new Hobby("dancing",3,addressList1);
        Hobby hobby2=new Hobby("swimming",5,addressList2);
        Hobby hobby3=new Hobby("cycling",5,addressList3);
        Hobby hobby4=new Hobby("hiking",2,addressList4);

        List<Hobby>hobbyList1=new ArrayList<>();
        hobbyList1.add(hobby1);
        hobbyList1.add(hobby2);
        hobbyList1.add(hobby3);

        List<Hobby>hobbyList2=new ArrayList<>();
        hobbyList2.add(hobby2);
        hobbyList2.add(hobby3);
        hobbyList2.add(hobby4);

        Person person1=new Student("Florin",19);
        Person person2=new Hired("Gabriela",35);

        // creare HashMap
        Map<Person,List<Hobby>>personListMap=new HashMap<>();
        personListMap.put(person1,hobbyList1);
        personListMap.put(person2,hobbyList2);

        // iterare prin HashMap
        for (Map.Entry<Person,List<Hobby>>entry:personListMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println();

        //get values based on key
        List<Hobby> var=personListMap.get(person1);
        System.out.println("The hobbies of "+person1.getName()+" are: "+var);

        System.out.println();

       // un alt mod de a stoca si a printa hobbies list pt o anumita persoana. ne folosim de alt constructor
        Person person3=new Hired("Ovi",25,hobbyList2);
        List<Hobby> hobbyList = person3.getHobbyList();
        System.out.println("The hobbies of "+person3.getName()+" are: "+hobbyList);

    }
}
