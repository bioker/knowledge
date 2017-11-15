package net.wls.learn.spring.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollections {

    private List addressesList;
    private Set addressesSet;
    private Map addressesMap;
    private Properties addressesProp;

    public List getAddressesList() {
        System.out.println("List: " + addressesList);
        return addressesList;
    }

    public void setAddressesList(List addressesList) {
        this.addressesList = addressesList;
    }

    public Set getAddressesSet() {
        System.out.println("Set: " + addressesSet);
        return addressesSet;
    }

    public void setAddressesSet(Set addressesSet) {
        this.addressesSet = addressesSet;
    }

    public Map getAddressesMap() {
        System.out.println("Map: " + addressesMap);
        return addressesMap;
    }

    public void setAddressesMap(Map addressesMap) {
        this.addressesMap = addressesMap;
    }

    public Properties getAddressesProp() {
        System.out.println("Prop: " + addressesProp);
        return addressesProp;
    }

    public void setAddressesProp(Properties addressesProp) {
        this.addressesProp = addressesProp;
    }
}
