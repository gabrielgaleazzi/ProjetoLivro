/**
 * 
 */
package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

/**
 * @author gabrielgaleazzi
 *
 */
@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	private Integer autorId;
	
	public List<Livro> getLivros()
	{
		return new DAO<Livro>(Livro.class).getLivros();
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	public Livro getLivro()
	{
		return this.livro;
	}
	public List<Autor> getAutores()
	{
		
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	public List<Autor> getAutoresDoLivro()
	{
		return this.livro.getAutores();
	}
	public void gravarAutor() {
		
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionarAutor(autor);
		System.out.println("Escrito por :"+ autor.getNome());
	}
	
	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());
		if(livro.getAutores().isEmpty())
		{
			FacesContext.getCurrentInstance().addMessage("Autor", new FacesMessage("Livro deve conter pelo menos um autor"));
		}
		new DAO<Livro>(Livro.class).adiciona(this.livro);
		livro = new Livro();
	}
	
	public void validISBN(FacesContext fc,UIComponent component, Object value) throws ValidatorException
	{
		String valor = value.toString();
		if(!valor.startsWith("1"))
			throw new ValidatorException(new FacesMessage("ISBN comeca com 1"));
		
		
	}
	
	public String formAutor()
	{
		System.out.println("Chamando o formulario do autor");
		return "autor?faces-redirect-true";
	}
	
}
