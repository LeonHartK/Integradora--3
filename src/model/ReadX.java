package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadX {

	ArrayList<User> users;
	ArrayList<Producto> products;
	ArrayList<Suscripcion> suscripciones;

	public ReadX() {
		this.users = new ArrayList<>();
		this.products = new ArrayList<>();
		this.suscripciones = new ArrayList<>();
	}

	public String addUser(String name, String id, Date bindingDate) {
		String message = "";
		if (!searchUser(id)) {
			users.add(new StandarUser(name, id, bindingDate));
			message = "El usuario fue creado con exito";
		} else {
			message = "El usuario ya se encuentra creado";
		}
		return message;
	}

	public String addPremiumUser(String name, String id, Date bindingDate) {
		String message = "";
		if (!searchUser(id)) {
			users.add(new PremiumUser(name, id, bindingDate));
			message = "El usuario fue creado con exito";
		} else {
			message = "El usuario ya se encuentra creado";
		}
		return message;
	}

	public boolean searchUser(String id) {
		boolean status = false;
		for (int i = 0; i < users.size() && !status; i++) {
			if (users.get(i).getCedula().equalsIgnoreCase(id)) {
				status = true;
			}
		}
		return status;
	}

	public String addBook(String id, String name, int totPages, Date datePost, String url, String reseña,
			int typeGenre, double saleValue) {
		String message = "";
		if (!searchProduct(id)) {
			products.add(new Libro(id, name, totPages, datePost, url, reseña, getNameGenre(typeGenre), saleValue));
			message = "El libro fue creado con exito";
		} else {
			message = "El libro ya se encuentra creado";
		}
		return message;
	}

	public typeGenre getNameGenre(int genre) {
		switch (genre) {
			case 1:
				return typeGenre.SCIENCEFICTION;
			case 2:
				return typeGenre.FANCY;
			case 3:
				return typeGenre.HISTORICALNOVEL;
		}
		return null;
	}

	public String addRevista(String id, String name, int totPages, Date datePost, String url,
			int typeCategoria, double subcriptionValue, String issuancePeriodicity) {
		String message = "";
		if (!searchProduct(id)) {
			products.add(
					new Revista(id, name, totPages, datePost, url, getNameCategory(typeCategoria), subcriptionValue,
							issuancePeriodicity));
			message = "La revista fue creado con exito";
		} else {
			message = "La revista ya se encuentra creada";
		}
		return message;
	}

	public typeCategory getNameCategory(int category) {
		switch (category) {
			case 1:
				return typeCategory.VARIETIES;
			case 2:
				return typeCategory.DESIGN;
			case 3:
				return typeCategory.SCIENTIFIC;
		}
		return null;
	}

	public boolean searchProduct(String id) {
		boolean status = false;
		for (int i = 0; i < products.size() && !status; i++) {
			if (products.get(i).getId().equalsIgnoreCase(id)) {
				status = true;
			}
		}
		return status;
	}

	public Producto searchObjProduct(String id) {
		boolean status = false;
		Producto product = null;
		for (int i = 0; i < products.size() && !status; i++) {
			if (products.get(i).getId().equalsIgnoreCase(id)) {
				product = products.get(i);
				status = true;
			}
		}
		return product;
	}

	public User searchUserObj(String id) {
		boolean status = false;
		User user = null;
		for (int i = 0; i < users.size() && !status; i++) {
			if (users.get(i).getCedula().equalsIgnoreCase(id)) {
				status = true;
				user = users.get(i);
			}
		}
		return user;
	}

	public String eliminarPorId(String id) {
		String message = "El producto no se encuentra creado";
		// Buscamos y eliminamos el objeto con el ID dado
		for (int i = 0; i < products.size(); i++) {
			Producto mueble = products.get(i);
			if (mueble.getId().equalsIgnoreCase(id)) {
				products.remove(i);
				message = "El producto fue removido exitosamente";
			}
		}
		return message;
	}

	public Date parseo(String fecha) throws InputMismatchException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date testDate = null;

		String date = fecha;

		try {
			testDate = df.parse(date);
		} catch (Exception e) {
			throw new InputMismatchException("Format invalid");
		}

		if (!df.format(testDate).equals(date)) {
			throw new InputMismatchException("Format invalid");
		}
		return testDate;
	}

	public String buyBook(String userId, String id) {
		String message = "";
		User user = searchUserObj(userId);
		Producto libro = searchObjProduct(id);
		if (libro instanceof Libro && libro != null) {
			message = user.buyBook(libro);
		} else if (libro == null) {
			message = "No se encontro el libro";
		} else if (!(libro instanceof Libro)) {
			message = "Este producto no es de tipo libro";
		}
		return message;
	}

	public String suscripcion(String userId, String revistaId) {
		String message = "";
		User user = searchUserObj(userId);
		Producto revista = searchObjProduct(revistaId);
		if (revista instanceof Revista && revista != null) {
			message = user.suscripcion(revista);
			Revista rev = (Revista) revista;
			if (user.searchProduct(revistaId) == false) {
				suscripciones.add(new Suscripcion(user, revista, new Date(), rev.getSubcriptionValue()));
			}
		} else if (revista == null) {
			message = "No se encontro la revista";
		} else if (!(revista instanceof Revista)) {
			message = "Este producto no es de tipo revista";
		}
		return message;
	}

	public String seeProducts(String userId) {
		String message = "";
		User user = searchUserObj(userId);
		if (user != null) {
			message = user.seeProducts();
		}
		return message;
	}

	public boolean isUser(User user) {
		return user instanceof User;
	}

	public ArrayList<Producto> getProductos() {
		return products;
	}

	public void leerUserStandar() throws FileNotFoundException {

		File directorio = new File(System.getProperty("user.dir") + "/src/inData/UserStand.txt");
		Scanner infile = new Scanner(directorio);

		String name;
		String id;

		while (infile.hasNext()) {
			name = infile.nextLine();
			id = infile.nextLine();

			addUser(name, id, new Date());
		}
		infile.close();
	}

	public void leerUserPremium() throws FileNotFoundException {

		File directorio = new File(System.getProperty("user.dir") + "/src/inData/UserPremium.txt");
		Scanner infile = new Scanner(directorio);

		String name;
		String id;

		while (infile.hasNext()) {
			name = infile.nextLine();
			id = infile.nextLine();

			addPremiumUser(name, id, new Date());
		}
		infile.close();
	}

	public void leerLibros() throws FileNotFoundException {
		File directorio = new File(System.getProperty("user.dir") + "/src/inData/libros.txt");
		Scanner infile = new Scanner(directorio);

		String id;
		String name;
		String totPages;
		String datePost;
		String url;
		String reseña;
		String typeGenre;
		String saleValue;

		while (infile.hasNext()) {
			id = infile.nextLine();
			name = infile.nextLine();
			totPages = infile.nextLine();
			datePost = infile.nextLine();
			url = infile.nextLine();
			reseña = infile.nextLine();
			typeGenre = infile.nextLine();
			saleValue = infile.nextLine();

			addBook(id, name, Integer.parseInt(totPages), parseo(datePost), url, reseña, Integer.parseInt(typeGenre),
					Double.parseDouble(saleValue));
		}
		infile.close();
	}

}