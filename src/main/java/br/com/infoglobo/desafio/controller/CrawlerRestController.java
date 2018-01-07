package br.com.infoglobo.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infoglobo.desafio.model.Rss;
import br.com.infoglobo.desafio.service.impl.CrawlerService;

/**
 * Classe controladora de Crawler
 *
 *
 * @author  Bruno Medeiros
 */

@CrossOrigin
@RestController
@RequestMapping("/api/crawler")
public class CrawlerRestController {   
	
	@Autowired
	CrawlerService crawlerService;
	
	/**
	 * Este método retorna um Json do tipo Rss
	 *  @return Json - Rss;
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<Rss> listFeeds() throws Exception {		
		return ResponseEntity.status(HttpStatus.OK).body(crawlerService.createJson());
	}
}





