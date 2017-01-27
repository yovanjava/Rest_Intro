package com.yovan.firstjerseyproject;

import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.yovan.firstjerseyproject.beans.MessagesBeanParams;
import com.yovan.firstjerseyproject.model.Message;
import com.yovan.firstjerseyproject.service.MessageService;

@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	/*
	 * @GET public List<Message> getMessage(
	 * 
	 * @QueryParam("year") int year,
	 * 
	 * @QueryParam("start") int start,
	 * 
	 * @QueryParam("size") int size) { if (year > 0) return
	 * messageService.getMessages(year); if (start >= 0 && size > 0) return
	 * messageService.getMessages(start, size); return
	 * messageService.getMessages(); }
	 */

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

	/*
	 * @POST public Message addMessage(Message message) { return
	 * messageService.addMessage(message); }
	 */

	/*
	 * @POST public Response addMessage(Message message) { message =
	 * messageService.addMessage(message); return
	 * Response.status(Status.CREATED) .entity(message) .build(); }
	 */

	/*
	 * @POST public Response addMessage(Message message) { message =
	 * messageService.addMessage(message); try { return Response.created(new
	 * URI("/001_First_Jersey_Project/webapi/messages/" + message.getId()))
	 * .entity(message) .build(); } catch (URISyntaxException e) {
	 * e.printStackTrace(); return null; } }
	 */

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		message = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder()
				.path(String.valueOf(message.getId()))
				.build();
		return Response.created(uri).entity(message).build();
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

	/*
	 * @GET
	 * 
	 * @Path("/{messageId}/comments") public List<Comment>
	 * getComments(@PathParam("messageId") long messageId){ List<Comment>
	 * commentsList = new ArrayList<>(); return commentsList; }
	 */

	@Path("/messagesId/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
