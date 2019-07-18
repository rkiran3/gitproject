package com.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Exercise to 
 */
 
class BaseItem {
    private Integer id;
    BaseItem() { id = new Integer(99); }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}

class DerivedItem extends BaseItem {
    private Integer id;
    DerivedItem() { id = new Integer(23); }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getSuperId() { return super.getId() ; }
    
}

public class HideVariableTest {

    public static void main( String [] args) {
        DerivedItem item = new DerivedItem();
        System.out.println(item.getId()); // will print the instance variable of Derived Item i.e 23
        System.out.println(item.getSuperId()); // invokes super.getId() returning BaseItem id i.e. 99
    }
}
