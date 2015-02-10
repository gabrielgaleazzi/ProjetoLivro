/**
 * 
 */
package br.com.caelum.livraria.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

import java.util.List;

/**
 * @author gabrielgaleazzi
 *
 */
public class PopulaBanco {

	public static void main(String argsp[]) throws java.text.ParseException {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Autor assis = geraAutor("Assis");
		em.persist(assis);

		Autor amado = geraAutor("Jorge Amado");
		em.persist(amado);

		Autor coelho = geraAutor("Paulo Coelho");
		em.persist(coelho);

		Livro casmurro = geraLivro("178998", "Dom Casmurro", "10/01/1899",
				24.90, assis);
		Livro memorias = geraLivro("181888", "Memorias Postumas de Bras Cubas",
				"01/01/1881", 19.90, assis);
		Livro quincas = geraLivro("19999", "Quincas Borba", "01/01/1891",
				16.90, assis);

		em.persist(casmurro);
		em.persist(memorias);
		em.persist(quincas);
		DAO<Autor> dao = new DAO(Autor.class);
		List<Autor> lista = dao.listaTodos();
		for (Autor autor : lista) {
			System.out.println("teste" + autor.getNome());
		}
		em.getTransaction().commit();
		em.close();
	}

	private static Autor geraAutor(String autor) {
		Autor gerado = new Autor();
		gerado.setNome(autor);
		return gerado;
	}

	private static Livro geraLivro(String isbn, String nome, String data,
			double preco, Autor autor) throws java.text.ParseException {
		Livro gerado = new Livro();
		gerado.setTitulo(nome);
		gerado.setPreco(preco);
		gerado.setIsbn(isbn);
		gerado.setDataLancamento(parseData(data));
		List<Autor> lista = new ArrayList<Autor>();
		lista.add(autor);
		gerado.setAutores(lista);

		return gerado;

	}

	private static Calendar parseData(String data)
			throws java.text.ParseException {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

	}
}