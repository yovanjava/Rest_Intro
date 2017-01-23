package com.yovan.firstjerseyproject;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yovan.firstjerseyproject.model.Message;
import com.yovan.firstjerseyproject.service.MessageService;

@Path("messages")
public class MessageResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		return MessageService.getMessages();
	}
}
