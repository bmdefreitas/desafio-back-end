package br.com.infoglobo.desafio.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import br.com.infoglobo.desafio.model.Description;
import br.com.infoglobo.desafio.model.Item;
import br.com.infoglobo.desafio.model.Rss;

/**
 * Classe de serviços do controlador de Crawler
 *
 *
 * @author  Bruno Medeiros
 */

@Service
public class CrawlerService {
	
	/**
	 * Este método retorna o Rss montado
	 *  @return Rss;
	 */
	public Rss createJson() throws IOException{
		Set<Item> feeds = new HashSet<Item>();	
		
		String url = "http://revistaautoesporte.globo.com/rss/ultimas/feed.xml";
		
        Document doc = Jsoup.connect(url).get();
        Elements items = doc.select("item");
        
        for (Element item : items) {
        	@SuppressWarnings("rawtypes")
			Set<Description> descriptions = new HashSet<Description>();
        	
        	Document docItem = Jsoup.parse(item.outerHtml());
        	Elements title = docItem.select("title");
        	Elements link = docItem.select("link");
        	Elements descElements = docItem.select("description");
        	
        	makeDescriptionList(descriptions, descElements);
        	
        	feeds.add(new Item(title.text(),link.val(), descriptions));
        }

		Rss rss = new Rss(feeds);
		
		return rss;
	}
	
	/**
	 * Este método monta uma lista de Descriptions
	 *  @return Rss;
	 */
	@SuppressWarnings("rawtypes")
	public void makeDescriptionList(Set<Description> descriptions, Elements descElements){
		Document docDescription = Jsoup.parse(descElements.text());
    	Elements p = docDescription.select("p");
    	Elements divImg = docDescription.select("div>img");        	
    	Elements divUl = docDescription.select("div>ul");
    	        	        	
    	for (Element element : p){
    		if(!element.text().isEmpty())
    		descriptions.add(new Description<String>("text",element.text()));
    	}
    	
    	for (Element element : divImg){
    		descriptions.add(new Description<String>("image",element.attr("src")));
    	}        	
    	for (Element element : divUl){
    		Document docDivUl = Jsoup.parse(element.outerHtml());
    		Elements li = docDivUl.select("li>a[href]");
    		List<String> content = new ArrayList<String>();
    		for(Element e : li){
    			content.add(e.attr("href"));
    		}
    		descriptions.add(new Description<List<String>>("links",content));
    		
    	}		
	}
}
