package tn.esprit.tt.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: SubscriptionDetail
 *
 */
@Entity

public class SubscriptionDetail implements Serializable {
	@EmbeddedId
	private SubsciptionId subsciptionId;
	private Integer duration;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idProduct", referencedColumnName = "id", updatable = false, insertable = false)
	private Product product;
	private static final long serialVersionUID = 1L;

	public SubscriptionDetail() {
		super();
	}

	public SubscriptionDetail(Integer duration, User user, Product product) {
		super();
		this.duration = duration;
		this.user = user;
		this.product = product;
		this.subsciptionId = new SubsciptionId(user.getId(), product.getId());
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SubsciptionId getSubsciptionId() {
		return subsciptionId;
	}

	public void setSubsciptionId(SubsciptionId subsciptionId) {
		this.subsciptionId = subsciptionId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
