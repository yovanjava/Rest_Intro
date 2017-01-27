package com.yovan.firstjerseyproject;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.yovan.firstjerseyproject.model.Comment;
import com.yovan.firstjerseyproject.service.CommentService;

public class CommentResource {
	
	private CommentService commentService = new CommentService();

	@GET
	public List<Comment> getComments(@PathParam("messageId") Long messageId){
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam ("messageId") Long messageId, @PathParam("commentId") Long commentId){
		return commentService.getComment(messageId, commentId);
		
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") Long messageId, Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void removeComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
		commentService.removeComment(messageId, commentId);
	}
	
	
}
