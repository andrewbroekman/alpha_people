package unittests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import javax.persistence.*;
import com.codinginfinity.research.people.*;
import com.codinginfinity.research.people.defaultImpl.*;

/*
 * Created by Mothusi Masibi
 */

public class PersonImplementationTest
{
	private Person person1, person2, person3;
	private static EntityManagerFactory factory;
	private EntityManager entityManager;
	private final String PERSISTENCE_UNIT_NAME = "RSSPeoplePersistence";
	
	@Before
	public void creatingAPersonShouldSucceed() throws InvalidEmailException 
	{
		person1 = new PersonImplementation("A","A","a@test.com",false);
		person2 = new PersonImplementation("B","B","a@test.com",false);
		person3 = new PersonImplementation("C","C","a@test.com",false);
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityManager = factory.createEntityManager();
	}
	
	@Test
	public void persistPersonShouldSucceed()
	{
		entityManager.getTransaction().begin();
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Test
	public void getObjectsShouldSucceed()
	{
		entityManager.getTransaction().begin();
		Person retrievedPerson = entityManager.find(PersonImplementation.class, BigInteger.valueOf(0));
		System.out.println(retrievedPerson);
		entityManager.close();
	}
	
}
