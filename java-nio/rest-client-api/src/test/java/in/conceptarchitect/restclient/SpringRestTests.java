package in.conceptarchitect.restclient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SpringRestTests {

	Movie newMovie=new Movie("test0001","Test Movie","2011","/images/test0001.jpg",8.2,2000,4.5,"Test Details","test");
	ApplicationContext context;
	RestTemplate rest;
	//String url="http://api.conceptarchitect.in/api/";
	String url="http://localhost:64293/api/";
	
	@Before
	public void setup() {
		rest = new RestTemplate(); //provided by spring framework
		 
		//define converts to conver xml, json etc to java object
		 List<HttpMessageConverter<?>> messageConverters = 
					new ArrayList<HttpMessageConverter<?>>();
		 
		 ObjectMapper mapper=new ObjectMapper();
		 
		 //ignore case difference between json field and java field
		 mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		 MappingJackson2HttpMessageConverter converter =
					new MappingJackson2HttpMessageConverter();
		 
		 converter.setObjectMapper(mapper);
		 
		 messageConverters.add(converter);
		 
		 rest.setMessageConverters(messageConverters);
		 
		 
		
	}
	
	@Test()
	public void canRetrieveUrlAsJson() {
		
		
		final RestTemplate restTemplate = new RestTemplate();

		String data=restTemplate.getForObject(url+"movies",String.class);
		//String data=response.getBody();
		System.out.println(data);
		assertTrue(data.length()>0);
	}
	
	
	@Test
	public void canRetrieveSingleMovieObject() {
		String imdbId="tt0076759";
		
		Movie movie = getMovieById(imdbId);
		
		assertNotNull(movie);
		System.out.println(movie);
		assertEquals(imdbId, movie.getImdbID());
	}

	private Movie getMovieById(String imdbId) {
		url+="movie/"+imdbId;
		
		Movie movie=rest.getForObject(url, Movie.class);
		return movie;
	}
	
	@Test
	public void canRetrieveListOfMovies() {
		url+="movies";
		
		
		Movie[] movies= rest.getForObject(url, Movie[].class);
		
		for(Movie movie:movies)
			System.out.println(movie);
		
		assertTrue(movies.length>0);
	}

	
	ResponseEntity<Movie> addMovie(Movie movie) {
		return rest.postForEntity(url+"movies", newMovie, Movie.class);
	}
	
	void deleteMovie(String id) {
		rest.delete(url+"movie/"+id);
	}
	
	
	@Test
	public void canAddMovie() {
		
		ResponseEntity<Movie> response=addMovie(newMovie);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
		deleteMovie(newMovie.getImdbID());
		
	}
	
	@Test
	public void canUpdateMovie() {
		String modifiedTitle="modified title";
		addMovie(newMovie);
		newMovie.setTitle(modifiedTitle);
		
		rest.put(url+"movie/"+newMovie.getImdbID(), newMovie);
		
		Movie movie2=getMovieById(newMovie.getImdbID());
		
		assertEquals(modifiedTitle, movie2.getTitle());
		
	}
	
	
	
	
}
