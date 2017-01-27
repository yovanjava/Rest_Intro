package com.yovan.firstjerseyproject;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getData(@MatrixParam("matParam") String matrixParam, 
			@HeaderParam("authSessionId") String sessionId,
			@CookieParam("name") String name
			) {
		return "Matrix Param: " + matrixParam + 
				"\nSession Param: " + sessionId + 
				"Cookie param: " + name;
	}

	@GET
	@Path("mycontext")
	public String getContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		Map<String, Cookie> cookies = httpHeaders.getCookies();
		String cookieValues = "";
		for (Cookie cookieValue : cookies.values()) {
			cookieValues += cookieValue;
		}
		return "Absolute path: " + uriInfo.getAbsolutePath().toString() + "\n" +
		"Cookie values: " + cookieValues;
	}

}
