package model;

import java.util.Date;

public class Suscripcion {
    private User user;
    private Producto product;
    private Date dateSuscripcion;
    private double valorSuscripcion;

    public Suscripcion() {

    }

    public Suscripcion(User user, Producto producto, Date dateSuscripcion, double valorSuscripcion) {
        this.user = user;
        this.product = producto;
        this.dateSuscripcion = dateSuscripcion;
        this.valorSuscripcion = valorSuscripcion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public Date getDateSuscripcion() {
        return dateSuscripcion;
    }

    public void setDateSuscripcion(Date dateSuscripcion) {
        this.dateSuscripcion = dateSuscripcion;
    }

    public double getValorSuscripcion() {
        return valorSuscripcion;
    }

    public void setValorSuscripcion(double valorSuscripcion) {
        this.valorSuscripcion = valorSuscripcion;
    }
}
