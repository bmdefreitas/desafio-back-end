package br.com.infoglobo.desafio.model;

/**
 * Classe para objetos do tipo Description.
 *
 *
 * @author  Bruno Medeiros
 */

public class Description<T> {
			
	//Construtor
	public Description() {
		super();
	}

	//Construtor
	public Description(String type, T content) {
		super();
		this.type = type;
		this.content = content;
	}
	

	private String type;
	
	private T content;
	

	/**
	 * Este método retorna o type
	 *  @return String - type;
	 */
	public String getType() {
		return type;
	}

	/**
	 * Este método atribui valor ao type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Este método retorna o content
	 *  @return Generic - content;
	 */
	public T getContent() {
		return content;
	}

	/**
	 * Este método atribui valor ao content
	 */
	public void setContent(T content) {
		this.content = content;
	}
	
}
