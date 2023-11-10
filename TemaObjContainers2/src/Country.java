public class Country {
    String countryName;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object obj) {
        Country other=(Country) obj;
        return this.getCountryName().equals(other.getCountryName());
    }
    @Override
    public int hashCode() {
        int result=0;
        result= result+(getCountryName() != null ? getCountryName().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Country{"+
                "countryName='"+getCountryName()+
                '\'';
    }
}
