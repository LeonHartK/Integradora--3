package ui;

import model.ReadX;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner entrada;
    ReadX mensajero;
    String currentUser;

    public Main() {
        entrada = new Scanner(System.in);
        mensajero = new ReadX();
    }

    public static void main(String[] args) {
        Main cavi = new Main();

        int opc;

        do {
            opc = cavi.menuprincipal();

            cavi.ejecutar(opc);
        } while (opc != 4);

    }

    public int menuprincipal() {
        System.out.println("1) Iniciar Sesion");
        System.out.println("2) Registrar usuario");
        System.out.println("3) Soy Administrador");
        System.out.println("4) Salir");

        int n = entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public int menuOpcUser() {
        System.out.println("Selecciona el tipo de usuario: ");
        System.out.println("1) Usuario Estandar");
        System.out.println("2) Usuario Premium");
        int n = entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public void registerUserStandard() {
        System.out.println("Digita su nombre de usuario");
        String nombre = entrada.nextLine();
        System.out.println("Digita tu numero de cedula");
        String ced = entrada.nextLine();
        Date bindingDate = new Date();

        System.out.println(mensajero.addUser(nombre, ced, bindingDate));
    }

    public void registerUserPremium() {
        System.out.println("Digita su nombre de usuario");
        String nombre = entrada.nextLine();
        System.out.println("Digita tu numero de cedula");
        String ced = entrada.nextLine();
        Date bindingDate = new Date();

        System.out.println(mensajero.addPremiumUser(nombre, ced, bindingDate));
    }

    public int menu() {
        System.out.println("Este es el menú principal");
        System.out.println("1) Comprar un libro");
        System.out.println("2) Suscribirse a una revista");
        System.out.println("3) Tener sesion de lectura");
        System.out.println("4) Ver mis productos");
        System.out.println("5) Cerrar Sesion");

        int n = entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public int menuAdmin() {
        System.out.println("Menu de gestion de productos bibliograficos");
        System.out.println("¿Que deseas gestionar?");
        System.out.println("1) Libro");
        System.out.println("2) Revista");
        int n = entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public int menuAdmin2() {
        System.out.println("¿Que deseas hacer?");
        System.out.println("1) Registrar libro");
        System.out.println("2) Remover libro");
        int n = entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public int menuAdmin3() {
        System.out.println("¿Que deseas hacer?");
        System.out.println("1) Registrar revista");
        System.out.println("2) Remover revista");
        int n = entrada.nextInt();
        entrada.nextLine();

        return n;
    }

    public void registerBook() {
        System.out.println("Digite el id del libro a registrar");
        String id = entrada.nextLine();

        System.out.println("Escribe el nombre del libro a registrar");
        String nombre = entrada.nextLine();

        System.out.println("Escribe el numero de paginas del libro");
        int paginas = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Escribe la fecha en que se posteo el libro");
        String fecha = entrada.nextLine();

        Date fechaactualizada = null;

        try {
            fechaactualizada = mensajero.parseo(fecha);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        System.out.println("Escribe el vinculo al repositorio con la portada");
        String vinculo = entrada.nextLine();

        System.out.println("Escribe una reseña corta");
        String reseña = entrada.nextLine();

        System.out.println(
                "Escriba el tipo de capsula para la situacion: \n1) SCIENCEFICTION\n2) FANCY\n3) HISTORICALNOVEL");
        int typeGenre = entrada.nextInt();

        System.out.println("Escribe el valor de venta del producto");
        int valor = entrada.nextInt();
        entrada.nextLine();

        System.out.println(mensajero.addBook(id, nombre, paginas, fechaactualizada, vinculo, reseña, typeGenre, valor));
    }

    public void removeBook() {
        System.out.println("Escribe el id del producto a remover");
        String id = entrada.nextLine();

        System.out.println(mensajero.eliminarPorId(id));
    }

    public void registerRevista() {
        System.out.println("Escribe el id del producto");
        String id = entrada.nextLine();

        System.out.println("Escribe el nombre de la reviste a registrar");
        String nombre = entrada.nextLine();

        System.out.println("Escribe el numero de paginas de la revista a registrar");
        int paginas = entrada.nextInt();

        System.out.println("Escribe la fecha en que se posteo la revista");
        String fecha = entrada.nextLine();

        Date fechaactualizada = null;

        try {
            fechaactualizada = mensajero.parseo(fecha);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        System.out.println("Escribe el vinculo al repositorio con la portada");
        String vinculo = entrada.nextLine();

        System.out.println(
                "Escriba el tipo de capsula para la situacion: \n1) VARIETIES\n2) DESIGN\n3) SCIENTIFIC");
        int typeGenre = entrada.nextInt();

        System.out.println("Escribe el valor de la suscripcion a la revista");
        double valor = entrada.nextInt();

        System.out.println("Escribe la periodicidad del producto");
        String periodicidad = entrada.nextLine();

        System.out.println(
                mensajero.addRevista(id, nombre, paginas, fechaactualizada, vinculo, typeGenre, valor, periodicidad));
    }

    public void removeRevista() {
        System.out.println("Escribe el id de la revista a remover");
        String id = entrada.nextLine();

        System.out.println(mensajero.eliminarPorId(id));
    }

    public void buyBook() {
        System.out.println("Digite el id del libro que desea comprar");
        String name = entrada.nextLine();
        System.out.println(mensajero.buyBook(getCurrentUser(), name));
    }

    public void suscripcionRevista() {
        System.out.println("Digite el id de la revista que desea suscripcion");
        String id = entrada.nextLine();
        System.out.println(mensajero.suscripcion(getCurrentUser(), id));
    }

    public void seeProduct() {
        System.out.println(mensajero.seeProducts(getCurrentUser()));
    }

    public void ejecutar(int n) {
        if (n == 1) {
            int nume = 0;
            System.out.println("Digita tu id (Cedula)");
            String id = entrada.nextLine();
            if (mensajero.searchUser(id) == true) {
                setCurrentUser(id);
                if (mensajero.isUser(mensajero.searchUserObj(id))) {
                    do {
                        nume = menu();
                        if (nume == 1) {
                            buyBook();
                        } else if (nume == 2) {
                            suscripcionRevista();
                        } else if (nume == 3) {

                        } else if (nume == 4) {
                            seeProduct();
                        }
                    } while (nume != 5);
                }
            } else {
                System.out.println("Che algo anda mal, checate bien");
            }
        } else if (n == 2) {
            int num = menuOpcUser();
            if (num == 1) {
                registerUserStandard();
            } else if (num == 2) {
                registerUserPremium();
            }
        } else if (n == 3) {
            int exp = menuAdmin();
            if (exp == 1) {
                int exp2 = menuAdmin2();
                if (exp2 == 1) {
                    registerBook();
                } else if (exp2 == 2) {
                    removeBook();
                }
            } else if (exp == 2) {
                int exp3 = menuAdmin3();
                if (exp3 == 1) {
                    registerRevista();
                } else if (exp3 == 2) {
                    removeRevista();
                }
            }
        } else if (n == 4) {
            System.out.println("Saliendo...");
        }
    }

    /**
     * Gets the id of the current loged user
     * 
     * @return id of the user
     */
    public String getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the id of the last current user to the actual loged user
     * 
     * @param currentUser actual loged user id
     */
    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

}