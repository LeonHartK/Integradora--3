package model;

import java.util.Date;

public class StandarUser extends User {

    Producto[] products;

    public StandarUser(String name, String id, Date bindingDate) {
        super(name, id, bindingDate);
        this.products = new Producto[7];
    }

    @Override
    public String buyBook(Producto libro) {
        boolean status = false;
        String message = "No se puede acceder a más productos";
        for (int i = 0; i < products.length && !status; i++) {
            if (products[i] == null && !searchProduct(libro.getId())) {
                products[i] = libro;
                status = true;
                message = "El libro se agregó correctamente";
            } else {
                message = "El libro ya se encuentra en la lista";
            }
        }
        return message;
    }

    @Override
    public boolean searchProduct(String id) {
        boolean status = false;
        for (int i = 0; i < products.length && !status; i++) {
            if (products[0] != null) {
                if (products[i] != null) {
                    if (products[i].getId().equalsIgnoreCase(id)) {
                        status = true;
                    }
                }
            }
        }
        return status;
    }

    @Override
    public String suscripcion(Producto revista) {
        boolean status = false;
        String message = "No se puede acceder a más productos";
        for (int i = 0; i < products.length && !status; i++) {
            if (products[i] == null && !searchProduct(revista.getId())) {
                products[i] = revista;
                status = true;
                message = "La revista se agregó correctamente";
            } else {
                message = "La revista ya se encuentra en la lista";
            }
        }
        return message;
    }

    public String seeProducts() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < products.length; i++) {
            if (products[0] != null) {
                if (products[i] != null) {
                    sb.append("Id: ").append(products[i].getId()).append("\n");
                    sb.append("Name: ").append(products[i].getName()).append("\n");
                    sb.append("Total de paginas: ").append(products[i].getTotPages()).append("\n");
                    sb.append("Fecha de publicacion: ").append(products[i].getDatePost()).append("\n");
                    sb.append("URL: ").append(products[i].getUrl()).append("\n");
                    sb.append("Total de paginas leidas: ").append(products[i].getTotPagesRead()).append("\n");
                    sb.append("--------------------\n");
                }
            }
        }
        String resultado = sb.toString();

        return resultado;
    }

}
