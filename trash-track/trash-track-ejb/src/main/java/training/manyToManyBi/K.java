package training.manyToManyBi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: K
 *
 */
@Entity

public class K implements Serializable {

	   
	@Id
	private int idK;
	
	@ManyToMany
	private List<L> ls;
	private static final long serialVersionUID = 1L;

	public K() {
		super();
	}   
	public int getIdK() {
		return this.idK;
	}

	public void setIdK(int idK) {
		this.idK = idK;
	}
	public List<L> getLs() {
		return ls;
	}
	public void setLs(List<L> ls) {
		this.ls = ls;
	}
   
}
