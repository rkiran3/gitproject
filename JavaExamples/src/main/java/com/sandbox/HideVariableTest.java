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
        DerivedItem baseItem = new DerivedItem();
        System.out.println(baseItem.getId());
        System.out.println(baseItem.getSuperId());
    }
}
