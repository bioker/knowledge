package net.wls.learn.spring.autowiring;

public class Person {

    private Address address;

    public Person() {
    }

    public Person(Address address1) {
        this.address = address1;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
