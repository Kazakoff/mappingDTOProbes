/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.hibernate.DTO;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import net.codejava.hibernate.Category;

/**
 *
 * @author User
 */
@Data
public class ProductDTO {

	private String name;
	private String description;
	private float price;
        private float amount;
        @Override
        
        public String toString(){
            return name + " - " + description + ", " + price + " - " + amount ;
        }
}
