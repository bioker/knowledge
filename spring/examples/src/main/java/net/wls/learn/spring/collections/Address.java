package net.wls.learn.spring.collections;

public class Address {

    private String country;

    public Address(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                '}';
    }
}
