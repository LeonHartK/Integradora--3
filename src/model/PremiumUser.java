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

    public String seeProducts() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(0) != null) {
                if (products.get(i) != null) {
                    sb.append("Id: ").append(products.get(i).getId()).append("\n");
                    sb.append("Name: ").append(products.get(i).getName()).append("\n");
                    sb.append("Total de paginas: ").append(products.get(i).getTotPages()).append("\n");
                    sb.append("Fecha de publicacion: ").append(products.get(i).getDatePost()).append("\n");
                    sb.append("URL: ").append(products.get(i).getUrl()).append("\n");
                    sb.append("Total de paginas leidas: ").append(products.get(i).getTotPagesRead()).append("\n");
                    sb.append("--------------------\n");
                }
            }
        }
        String resultado = sb.toString();

        return resultado;
    }

}
