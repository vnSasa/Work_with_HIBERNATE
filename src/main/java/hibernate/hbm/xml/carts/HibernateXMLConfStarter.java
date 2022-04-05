package hibernate.hbm.xml.carts;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateXMLConfStarter {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Cart cart = new Cart("product","Andrew");
		
		Item item1 = new Item("sugar");
		Item item2 = new Item("oil");
		Item item3 = new Item("bread");
		Item item4 = new Item("solt");
		cart.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
				
		session.persist(cart);

		transaction.commit();
		session.close();

	}

}
