package model;

import java.util.ArrayList;
import java.util.Date;

public class ReadX {

	ArrayList<User> users;

	public ReadX(){
		this.users = new ArrayList<>();
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

	public void addProduct() {
		// TODO - implement ReadX.addProduct
		throw new UnsupportedOperationException();
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