package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;

import tn.esprit.tt.persistence.Product;
import tn.esprit.tt.services.interfaces.ProductServicesLocal;

@ManagedBean
@ViewScoped
public class ProductManagementBean {
	private String selectedItem;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	private Boolean displayForm2 = false;
	private Boolean displayForm1 = true;
	private Product productSelected = new Product();;
	@EJB
	private ProductServicesLocal productServicesLocal;
	private DataModel<Product> dataModel;

	private List<Product> products = new ArrayList<>();
	private Integer idCompany;

	public String doAddProduct() {
		productServicesLocal.addProduct(productSelected, idCompany);
		return "/pages/companyHome/home?faces-redirect=true";
	}

	public String selectItem() {
		return "";
	}

	public String doDeleteProduct() {
		productServicesLocal.deleteProduct(productSelected);
		return cancel();
	}

	public String cancel() {
		displayForm1 = true;
		displayForm2 = false;
		productSelected = new Product();
		return "";
	}

	public String selectProduct() {
		displayForm1 = false;
		displayForm2 = true;
		return null;
	}

	@PostConstruct
	public void init() {
		idCompany = loginBean.getUser().getId();
		products = productServicesLocal.findAllProductsByCompanyId(idCompany);
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

	public Boolean getDisplayForm2() {
		return displayForm2;
	}

	public void setDisplayForm2(Boolean displayForm2) {
		this.displayForm2 = displayForm2;
	}

	public Boolean getDisplayForm1() {
		return displayForm1;
	}

	public void setDisplayForm1(Boolean displayForm1) {
		this.displayForm1 = displayForm1;
	}

	public DataModel<Product> getDataModel() {
		dataModel.setWrappedData(productServicesLocal.findAllProductsByCompanyId(idCompany));
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	public Product getProductSelected() {
		return productSelected;
	}

	public void setProductSelected(Product productSelected) {
		this.productSelected = productSelected;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

}
