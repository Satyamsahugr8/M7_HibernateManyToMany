package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * A program that demonstrates using JPA annotations to map a bidirectional
 * many-to-many association in Hibernate framework.
 *
 */
public class UsersManager {

	public static void main(String[] args) {

		// loads configuration and mappings
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Group groupAdmin = new Group("Administrator Group");
		Group groupGuest = new Group("Guest Group");

		User user1 = new User("Tom", "tomcat", "tom@codejava.net");
		User user2 = new User("Mary", "mary", "mary@codejava.net");
		User user3 = new User("Johnny", "Password", "Johnny@gmail.com");

		groupAdmin.addUser(user1);
		groupAdmin.addUser(user2);

//        groupGuest.addUser(user3);

        user1.addGroup(groupGuest);
        user2.addGroup(groupAdmin);

		user3.addGroup(groupGuest);

//		groupGuest.addUser(user1);

		// user1 - admin,guest
		// user2 - admin
		// user3 - guest
		
		
		session.save(groupAdmin);
		session.save(groupGuest);

		session.getTransaction().commit();
		session.close();
	}

}