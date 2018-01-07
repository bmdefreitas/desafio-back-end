package br.com.infoglobo.desafio.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe para objetos do tipo Rss.
 *
 *
 * @author  Bruno Medeiros
 */

public class Rss {
	
	//Construtor 
	public Rss(Set<Item> feed) {
		super();
		this.feed = feed;
	}
	
	//Construtor
	public Rss() {
		super();
	}
	
	
	private Set<Item> feed = new HashSet<>();

	
	/**
	 * Este método retorna o feed
	 *  @return Feed;
	 */
	public Set<Item> getFeed() {
		return feed;
	}
	
	/**
	 * Este método atribui valor ao feed
	 */
	public void setFeed(Set<Item> feed) {
		this.feed = feed;
	}

}
