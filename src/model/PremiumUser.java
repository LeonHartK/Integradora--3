package model;

import java.util.ArrayList;
import java.util.Date;

public class PremiumUser extends User{
    
    ArrayList<Producto> products;

    public PremiumUser(String name, String id, Date bindingDate){
        super(name, id, bindingDate);
        this.products = new ArrayList<>();
    }

}
