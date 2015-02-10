/**
 * 
 */
package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author gabrielgaleazzi
 *
 */
public class JPAUtil {

	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("Livro");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
