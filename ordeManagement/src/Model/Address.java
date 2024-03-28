package ordeManagement.src.Model;

public class Address {
    private int id;
    private String address1;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private boolean isPrimary;

    public int getId() {
        return id;
    }
    public String getAddress1() {
        return address1;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
  
    public String getState() {
        return state;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

