package model;

import java.util.ArrayList;
import java.util.Date;

public class ReadX {

	ArrayList<User> users;
	ArrayList<Producto> products;

	public ReadX(){
		this.users = new ArrayList<>();
		this.products = new ArrayList<>();
	}

	public String addUser(String name, String id, Date bindingDate) {
		// TODO - implement ReadX.addUser
		String message = "";
		if(!searchUser(id)){
			users.add(new StandarUser(name, id, bindingDate));
			message = "El usuario fue creado con exito";
		} else {
			message = "El usuario ya se encuentra creado";
		}
		return message;
	}

	public String addPremiumUser(String name, String id, Date bindingDate){
		String message = "";
		if(!searchUser(id)){
			users.add(new PremiumUser(name, id, bindingDate));
			message = "El usuario fue creado con exito";
		} else {
			message = "El usuario ya se encuentra creado";
		}
		return message;
	}

	public boolean searchUser(String id){
		boolean status = false;
		for(int i=0; i<users.size() && !status; i++){
			if(users.get(i).getCedula().equalsIgnoreCase(id)){
				status = true;
			} 
		}
		return status;
	}

	public String addBook(String id, String name, int totPages, Date datePost, String url, String reseña, typeGenre typeGenre, double saleValue){
		String message = "";
		if(!searchProduct(id)){
			products.add(new Libro(id, name, totPages, datePost, url, reseña, typeGenre, saleValue));
			message = "El libro fue creado con exito";
		} else{
			message = "El libro ya se encuentra creado";
		}
		return message;
	}

	public String addRevista(String id, String name, int totPages, Date datePost, String url, typeCategory typeCategoria, double subcriptionValue, String issuancePeriodicity){
		String message = "";
		if(!searchProduct(id)){
			products.add(new Revista(id, name, totPages, datePost, url, typeCategoria, subcriptionValue, issuancePeriodicity));
			message = "La revista fue creado con exito";
		} else{
			message = "La revista ya se encuentra creada";
		}
		return message;
	}

	public boolean searchProduct(String id){
		boolean status = false;
		for(int i=0; i<products.size() && !status; i++){
			if(products.get(i).getId().equalsIgnoreCase(id)){
				status = true;
			}
		}
		return status;
	}

	public Producto searchObjProduct(String id){
		boolean status = false;
		Producto product = null;
		for(int i=0; i<products.size() && !status; i++){
			if(products.get(i).getId().equalsIgnoreCase(id)){
				product = products.get(i);
				status = true;
			}
		}
		return product;
	}

	public String removeProduct(String id){
		String message = "";
		if(searchObjProduct(id) != null){
			products.remove(searchObjProduct(id));
			message = "El producto fue removido con exito";
		} else{
			message = "El producto no existe en la base de datos";
		}
		return message;
	}

	public void modifyProduct() {
		// TODO - implement ReadX.modifyProduct
		throw new UnsupportedOperationException();
	}

	public void deleteProduct() {
		// TODO - implement ReadX.deleteProduct
		throw new UnsupportedOperationException();
	}

	public void buyBook() {
		// TODO - implement ReadX.buyBook
		throw new UnsupportedOperationException();
	}

	public void subcribeMagazine() {
		// TODO - implement ReadX.subcribeMagazine
		throw new UnsupportedOperationException();
	}

	public void readSessionSim() {
		// TODO - implement ReadX.readSessionSim
		throw new UnsupportedOperationException();
	}

	public void countTotPagesRead() {
		// TODO - implement ReadX.countTotPagesRead
		throw new UnsupportedOperationException();
	}

	public void mostReadBook() {
		// TODO - implement ReadX.mostReadBook
		throw new UnsupportedOperationException();
	}

	public void mostReadMagazine() {
		// TODO - implement ReadX.mostReadMagazine
		throw new UnsupportedOperationException();
	}

	public void orderTop5() {
		// TODO - implement ReadX.orderTop5
		throw new UnsupportedOperationException();
	}

}