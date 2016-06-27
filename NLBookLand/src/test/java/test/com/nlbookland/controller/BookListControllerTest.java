package test.com.nlbookland.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nlbookland.controller.BookListController;
import com.nlbookland.service.BookService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BookListControllerTest {
	@Mock
    private BookService bookService;
 
    @InjectMocks
    private BookListController bookListController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/ftl/");
        viewResolver.setSuffix(".ftl");
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookListController)
        		.setViewResolvers(viewResolver)
        		.build();
 
    }
	
	@Test
	public void testShowBookList() throws Exception {	
		this.mockMvc.perform(get("/booklist")).andExpect(status().isOk());		
	}
	
	@Test
	public void testShowBookListBadRequest() throws Exception {	
		this.mockMvc.perform(get("booklist")).andExpect(status().isNotFound());		
	}
	
}
