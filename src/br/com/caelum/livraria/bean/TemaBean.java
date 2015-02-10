/**
 * 
 */
package br.com.caelum.livraria.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author gabrielgaleazzi
 *
 */
@ManagedBean
@SessionScoped
public class TemaBean {

	private String tema="aristo";

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public List<String> getTemas()
	{
		return Arrays.asList("aristo","black-tie","blitzer","blue-sky",
				"casablanca","cupertino","dark-hive","dat-luv","eggplant"
				,"excite-bike","flick","glass-x","hot-sneaks","humanity",
				"le-frog","midnight","mint-choc");
	}
}
