/**
 * 
 */
package br.com.caelum.livraria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

/**
 * @author gabrielgaleazzi
 *
 */
public class DAO<T> {
	
	private final Class<T> classe;
	EntityManager em = new JPAUtil().getEntityManager();
	
	public Class<T> getClasse() {
		return classe;
	}
	
	public DAO(Class<T> classe)
	{
		this.classe=classe;
	}
	
	public void adiciona(T t)
	{
		
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void remove(T t)
	{
		
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
		em.close();
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Autor> listaTodos() {
	
		 return em.createQuery("from Autor").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Livro> getLivros()
	{
		return  em.createQuery("from Livro").getResultList();
	}
	public Autor buscaPorId(int id)
	{
		return (Autor) em.getReference(Autor.class, id);
		
	}
}
