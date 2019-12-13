package com.resteasy.app;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
@Path("/movie")
public class MovieLibrary 
{
	//Store the in memory movie list as our repository.
	static final List<Movie> MOVIE_LIST = new ArrayList<Movie>();
	
	//Build a dummy list of movies to work with.
	static {
		MOVIE_LIST.add(new Movie(2008,"Ghajini"));
		MOVIE_LIST.add(new Movie(2008,"Jodhaa Akbar"));
		MOVIE_LIST.add(new Movie(2008,"Gamyam"));
		MOVIE_LIST.add(new Movie(2008,"Jalsa"));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{year}")
	public Response getMovies(@PathParam("year") int year) throws YearException
	{
		if(year != 2008)
		{
			throw  new  YearException();
		}
		List<Movie> list = getMoviesByYear(year);
		GenericEntity<List<Movie>>  movieList =new  GenericEntity<List<Movie>>(list){ };
		ResponseBuilder  builder=Response.ok(movieList);
		Response  response = builder.build();
		return  response;
	}
	private List<Movie> getMoviesByYear(int targetYear) 
	{
		List<Movie> found = new ArrayList<Movie>();
		for(Movie movie : MOVIE_LIST) {
			if(movie.getYear() == targetYear)
				found.add(movie);
		}
		return found;
	}
}
