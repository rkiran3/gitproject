package com.sandbox;

/**
 * Exercise to check visibility of variable 
 */
 
class BaseItem {
    private Integer id;
    BaseItem() { id = Integer.valueOf(99); }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}

class DerivedItem extends BaseItem {
    private Integer id;
    DerivedItem() { id = Integer.valueOf(23); }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getSuperId() { return super.getId() ; }
    
}

public class HideVariableTest {

    public static void main( String [] args) {
        DerivedItem item = new DerivedItem();
        System.out.println(item.getId()); // will print the instance variable of Derived Item i.e 23
        assert(item.getId() == 23);
        
        System.out.println(item.getSuperId()); // invokes super.getId() returning BaseItem id i.e. 99
        assert(item.getSuperId() == 99);
    }
}
