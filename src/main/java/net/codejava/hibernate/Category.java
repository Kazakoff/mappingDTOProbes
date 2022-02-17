package net.codejava.hibernate;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "CATEGORY")
public class Category {
    
	@Id
	@Column(name = "CATEGORY_ID")
        @GeneratedValue
	private long id;
	private String name;

        @ManyToMany(mappedBy = "categorys", cascade = CascadeType.ALL)
	private List <Product> products;

	public Category() {
	}
	
	public Category(String name) {
		this.name = name;
	}

    /**
     * @return the products
     */
    public List <Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List <Product> products) {
        this.products = products;
    }
}