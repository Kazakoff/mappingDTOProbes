package net.codejava.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.codejava.hibernate.DTO.ProductDTO;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.modelmapper.ModelMapper;


public class StockManager {
    static  SessionFactory sessionFactory;
static{
    		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
}
	public static void main(String[] args) {
            fillDB();
            Session session = sessionFactory.openSession();
	    session.beginTransaction();
            Query q = session.createQuery("FROM Product");
            List <Product> products = q.list();
            ModelMapper modelMapper = new ModelMapper();
            ProductDTO productDTO;
            for (Product p : products)
            {
                productDTO = modelMapper.map(p, ProductDTO.class);
                System.out.println(productDTO);
            }
            session.close();
	}
        
       public static void fillDB() {

		
		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Category categoryComp = new Category("Computer");
                Category categoryMob = new Category("Mobile");
		
		Product pc = new Product("DELL PC", "Quad-core PC", 1200, Arrays.asList(categoryComp));
		
		Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, Arrays.asList(categoryComp,categoryMob ));
		
		Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499,  Arrays.asList(categoryComp,categoryMob ));
		
		Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099,  Arrays.asList(categoryComp,categoryMob ));
		
		List <Product> products = new ArrayList<Product>();
		products.add(pc);
		products.add(laptop);
		products.add(phone);
		products.add(tablet);
		
		categoryComp.setProducts(products);
		categoryMob.setProducts(Arrays.asList(laptop,phone,tablet ));
		session.save(categoryComp);
                session.save(categoryMob);
		
		session.getTransaction().commit();
		session.close();		
       } 
}
