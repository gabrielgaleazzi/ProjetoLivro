/**
 * 
 */
package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;



/**
 * @author gabrielgaleazzi
 *
 */
@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor()
	{
		return this.autor;
	}
	

	public String gravar()
	{
		System.out.println("Gravando Autor "+this.getAutor().getNome());
		
		new DAO<Autor>(Autor.class).adiciona(this.autor);
		this.autor = new Autor();
		
		return "livro?faces-redirect-true";
	}
}
