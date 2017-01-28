package com.yovan.firstjerseyproject.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.yovan.firstjerseyproject.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable throwable) {
		ErrorMessage errorMessage = new ErrorMessage(throwable.getMessage(), 500, "http://www.yovan.com/errorMessage");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}
