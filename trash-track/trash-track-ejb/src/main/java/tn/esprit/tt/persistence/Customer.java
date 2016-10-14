package tn.esprit.tt.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.tt.persistence.User;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer extends User implements Serializable {

	
	private String address;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
	
	public Customer(String name, String address) {
		super(name);
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
   
}
