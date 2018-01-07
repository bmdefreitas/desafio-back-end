package br.com.infoglobo.desafio.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.infoglobo.desafio.model.Rss;
import br.com.infoglobo.desafio.service.impl.CrawlerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CrawlerRestController.class)
public class CrawlerRestControllerTests {
	
	@Autowired
    private MockMvc mvc;

    @MockBean
    private CrawlerService crawlerService;

    @Test
    public void testAccess() throws Exception {
        given(this.crawlerService.createJson())
                .willReturn(new Rss());
        this.mvc.perform(get("/api/crawler").with(user("admin")).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
    
}
