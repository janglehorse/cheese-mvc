package org.launchcode.models;

/**
 * Created by adminbackup on 3/8/17.
 */
public class Cheese {

    private String name;
    private String description;
    private Double price;

    public String getName(){
        return name;
    }

    public void setName(String aName){
        name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double calculatedHalfPrice(){
        return price / 2;
    }
}
