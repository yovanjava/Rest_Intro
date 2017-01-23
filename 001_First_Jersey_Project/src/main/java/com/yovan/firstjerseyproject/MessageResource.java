package com.yovan.firstjerseyproject;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yovan.firstjerseyproject.model.Message;
import com.yovan.firstjerseyproject.service.MessageService;

@Path("messages")
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		return messageService.getMessages();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message message) {
		return message;
	}

	@PUT
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(Message message) {
		return message;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	public Message removeMessage(long messageId) {
		Message message = null;
		return message;
	}
}
