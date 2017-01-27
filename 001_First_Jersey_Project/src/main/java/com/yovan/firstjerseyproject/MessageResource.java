package com.yovan.firstjerseyproject;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yovan.firstjerseyproject.beans.MessagesBeanParams;
import com.yovan.firstjerseyproject.model.Message;
import com.yovan.firstjerseyproject.service.MessageService;

@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	/*@GET
	public List<Message> getMessage(
			@QueryParam("year") int year, 
			@QueryParam("start") int start,
			@QueryParam("size") int size) {
		if (year > 0)
			return messageService.getMessages(year);
		if (start >= 0 && size > 0)
			return messageService.getMessages(start, size);
		return messageService.getMessages();
	}*/
	
	@GET
	public List<Message> getMessages(@BeanParam MessagesBeanParams beanParams) {
		if (beanParams.getYear() > 0)
			return messageService.getMessages(beanParams.getYear());
		if (beanParams.getStart() >= 0 && beanParams.getSize() > 0)
			return messageService.getMessages(beanParams.getStart(), beanParams.getSize());
		return messageService.getMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void removeMessage(@PathParam("messageId") long messageId) {
		messageService.removeMessage(messageId);
	}
}
