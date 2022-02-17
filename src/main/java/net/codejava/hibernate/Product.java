package net.codejava.hibernate;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.mapping.Set;
// dfsgtrfh
@Entity
@Data
@Table(name = "PRODUCT")
public class Product {
    	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private float price;
        private float amount;
	
      @ManyToMany(cascade = { CascadeType.ALL })
        @JoinTable(
        name = "Category_Product", 
        joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID") }
    )	
	private List <Category> categorys;

	public Product() {
	}

	public Product(String name, String description, float price,
			List <Category> categorys) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.categorys = categorys;
	}

}
