package br.com.infoglobo.desafio.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe para objetos do tipo Item.
 *
 *
 * @author  Bruno Medeiros
 */

public class Item {
	
	//Construtor
	public Item() {
		super();
	}
	
	//Construtor
	@SuppressWarnings("rawtypes")
	public Item(String title, String link, Set<Description> description) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
	}
	
	private String title;
	
	private String link;
	
	@SuppressWarnings("rawtypes")
	private Set<Description> description = new HashSet<Description>();

	
	/**
	 * Este método retorna o title
	 *  @return String - title;
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Este método atribui valor ao title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Este método retorna o link
	 *  @return String - link;
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Este método atribui valor ao link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Este método retorna os descriptions
	 *  @return HashSet - description;
	 */
	@SuppressWarnings("rawtypes")
	public Set<Description> getDescription() {
		return description;
	}

	/**
	 * Este método atribui valor a listagem de descriptions
	 */
	@SuppressWarnings("rawtypes")
	public void setDescription(Set<Description> description) {
		this.description = description;
	}
	
	

}
