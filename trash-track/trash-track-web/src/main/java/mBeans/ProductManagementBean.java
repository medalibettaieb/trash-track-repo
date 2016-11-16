package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.tt.persistence.Product;
import tn.esprit.tt.services.interfaces.ProductServicesLocal;

@ManagedBean
@ViewScoped
public class ProductManagementBean {
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	@EJB
	private ProductServicesLocal productServicesLocal;

	private Product product = new Product();
	private List<Product> products = new ArrayList<>();
	private Integer idCompany;

	public String doAddProduct() {

		productServicesLocal.addProduct(product, idCompany);
		return "/pages/companyHome/home?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		idCompany = loginBean.getUser().getId();
		products = productServicesLocal.findAllProductsByCompanyId(idCompany);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
