package com.yovan.firstjerseyproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yovan.firstjerseyproject.model.Comment;
import com.yovan.firstjerseyproject.model.Message;
import com.yovan.firstjerseyproject.util.DatabaseConnect;

public class CommentService {

	private Map<Long, Message> messagesMap = DatabaseConnect.getMessages();

	public List<Comment> getAllComments(Long messageId) {
		Map<Long, Comment> commentsMap = messagesMap.get(messageId).getCommentsMap();
		return new ArrayList<>(commentsMap.values());
	}

	public Comment getComment(Long messageId, Long commentId) {
		Map<Long, Comment> commentsMap = messagesMap.get(messageId).getCommentsMap();
		return commentsMap.get(commentId);
	}

	public Comment addComment(Long messageId, Comment comment) {
		Map<Long, Comment> commentsMap = messagesMap.get(messageId).getCommentsMap();
		comment.setId(commentsMap.size() + 1L);
		commentsMap.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(Long messageId, Comment comment) {
		Map<Long, Comment> commentsMap = messagesMap.get(messageId).getCommentsMap();
		if (comment.getId() <= 0)
			return null;
		commentsMap.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(Long messageId, Long commentId) {
		Map<Long, Comment> commentsMap = messagesMap.get(messageId).getCommentsMap();
		return commentsMap.remove(commentId);
	}

}
