import java.util.List;

public class Address {
    String continentName;
    List<Country> countryList;

    public Address(String continentName, List<Country> countryList) {
        this.continentName = continentName;
        this.countryList = countryList;
    }

    public Address() {
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "continentName='" + getContinentName() +
                "countryList'" + getCountryList() + '\'';
    }
}
