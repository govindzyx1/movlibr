
package com.resteasy.app;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class YearExceptionMapper implements ExceptionMapper<YearException> 
{
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(YearException e)
	{
		ErrorResponse  er = new  ErrorResponse();
		er.setMessage("Year is not valid, it must be 2008 only");
		Response.Status  httpStatus=Response.Status.BAD_REQUEST;
		ResponseBuilder builder = Response.status(httpStatus);
		builder.entity(er);
		Response  response=builder.build();
		return response;
	}
}
