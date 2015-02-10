/**
 * 
 */
package br.com.caelum.livraria.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author gabrielgaleazzi
 */

@Entity
public class Autor {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToMany
	private List<Livro> livros = new ArrayList<Livro>();
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 */
	@Column(unique=true)
	private String nome;

	/**
	 * 
	 */
	public Autor() {
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}