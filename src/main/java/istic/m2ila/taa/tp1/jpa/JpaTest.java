package istic.m2ila.taa.tp1.jpa;


	import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import istic.m2ila.taa.tp1.dao.DAO;
import istic.m2ila.taa.tp1.dao.PersonDAO;
import istic.m2ila.taa.tp1.domain.Lieu;
import istic.m2ila.taa.tp1.domain.Person;
import istic.m2ila.taa.tp1.domain.Sport;

	public class JpaTest {

		private EntityManager manager;

	    public JpaTest(EntityManager manager) {
	        this.manager = manager;
	    }

		/**
		 * @param args
		 */
		public static void main(String[] args) {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
			//EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
			EntityManager manager = factory.createEntityManager();

			JpaTest test = new JpaTest(manager);
			
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				
				test.createPersons();
				test.createLieux();
				test.createSports();
				
				//Person p = new Person();
				//p.setFirstname("Olivier");
				//manager.persist(p);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			//List<Person> ps = manager.createQuery("select p from Person as p").getResultList();
			//System.err.println(ps.size());
			
			test.listPersons();
			test.listLieux();
			test.listSports();
			
			PersonDAO personDao = new PersonDAO();
			
			//List<Person> liste = personDao.find();
			//for (Person p : liste) {
			//	System.out.println("-- " + p.getName() + " - " + p.getFirstname());
			//}
			
			long n = 1;
			//Person p = personDao.find(n);
			//System.out.println("****************");
			//System.out.println("Person #" + p.getId() + " : " + p.getName() + "-" + p.getFirstname());
			
			manager.close();
			EntityManagerHelper.closeEntityManagerFactory();
		}


		private void createPersons() {
	        int numOfPersons = manager.createQuery("Select a From Person a", Person.class).getResultList().size();

	        if (numOfPersons == 0) {
	        	Person p1 = new Person();
	        	p1.setName("Nom1");
	        	p1.setFirstname("Prénom1");
	        	manager.persist(p1);
	        	Person p2 = new Person();
	        	p2.setName("Nom2");
	        	p2.setFirstname("Prénom2");
	        	manager.persist(p2);
	        	Person p3 = new Person();
	        	p3.setName("Nom3");
	        	p3.setFirstname("Prénom3");
	        	manager.persist(p3);
	        }
	    }

	    private void listPersons() {
	        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
	        System.out.println("num of persons:" + resultList.size());
	        for (Person next : resultList) {	            System.out.println("next employee: " + next);
	        }
	    }
	    
		private void createLieux() {
	        int numOfLieux = manager.createQuery("Select a From Lieu a", Lieu.class).getResultList().size();
	        if (numOfLieux == 0) {
	        	Lieu l1 = new Lieu();
	        	l1.setNom("Lieu1");
	        	manager.persist(l1);
	        	Lieu l2 = new Lieu();
	        	l2.setNom("Lieu2");
	        	manager.persist(l2);
	        	Lieu l3 = new Lieu();
	        	l3.setNom("Lieu3");
	        	manager.persist(l3);
	        }
	    }

	    private void listLieux() {
	        List<Lieu> resultList = manager.createQuery("Select a From Lieu a", Lieu.class).getResultList();
	        System.out.println("num of lieux:" + resultList.size());
	        for (Lieu next : resultList) {	            System.out.println("next lieu: " + next);
	        }
	    }
	    
		private void createSports() {
	        int numOfSports = manager.createQuery("Select a From Sport a", Sport.class).getResultList().size();
	        if (numOfSports == 0) {
	        	Sport s1 = new Sport();
	        	s1.setNom("Sport1");
	        	manager.persist(s1);
	        	Sport s2 = new Sport();
	        	s2.setNom("Sport2");
	        	manager.persist(s2);
	        	Sport s3 = new Sport();
	        	s3.setNom("Sport3");
	        	manager.persist(s3);
	        }
	    }
		
	    private void listSports() {
	        List<Sport> resultList = manager.createQuery("Select a From Sport a", Sport.class).getResultList();
	        System.out.println("num of sports:" + resultList.size());
	        for (Sport next : resultList) {	            System.out.println("next sport: " + next);
	        }
	    }
	    
	}
