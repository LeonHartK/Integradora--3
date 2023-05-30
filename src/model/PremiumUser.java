package model;

import java.util.ArrayList;
import java.util.Date;

public class PremiumUser extends User {

    ArrayList<Producto> products;

    public PremiumUser(String name, String id, Date bindingDate) {
        super(name, id, bindingDate);
        this.products = new ArrayList<>();
    }

    @Override
    public String buyBook(Producto libro) {
        String message = "No se puede acceder a más productos";
        if (!searchProduct(libro.getId())) {
            products.add(libro);
            message = "El libro se agregó correctamente";
        } else {
            message = "El libro ya se encuentra en la lista";
        }
        return message;
    }

    @Override
    public boolean searchProduct(String id) {
        boolean status = false;
        for (int i = 0; i < products.size() && !status; i++) {
            if (products.get(i) != null) {
                if (products.get(i).getId().equalsIgnoreCase(id)) {
                    status = true;
                }
            }
        }
        return status;
    }

    @Override
    public String suscripcion(Producto revista) {
        String message = "No se puede acceder a más productos";
        if (!searchProduct(revista.getId())) {
            products.add(revista);
            message = "El libro se agregó correctamente";
        } else {
            message = "El libro ya se encuentra en la lista";
        }
        return message;
    }

}
