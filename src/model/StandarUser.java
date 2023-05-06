package model;

import java.util.Date;

public class StandarUser extends User{
    
    Producto[] products;

    public StandarUser(String name, String id, Date bindingDate){
        super(name, id, bindingDate);
        this.products = new Producto[7];
    }

}
