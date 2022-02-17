package net.codejava.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class StockManager {

	public static void main(String[] args) {
		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
		
		// builds a session factory from the service registry
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
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
