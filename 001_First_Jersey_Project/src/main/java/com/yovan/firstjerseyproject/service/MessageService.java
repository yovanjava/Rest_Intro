package com.yovan.firstjerseyproject.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yovan.firstjerseyproject.model.Message;
import com.yovan.firstjerseyproject.util.DatabaseConnect;

public class MessageService {

	private Map<Long, Message> messagesMap = DatabaseConnect.getMessages();

	public MessageService() {
		messagesMap.put(1L, new Message(1, "This is a new message", "john", new Date()));
		messagesMap.put(2L, new Message(2, "This is the second message", "paul", new Date()));
	}

	public List<Message> getMessages() {
		return new ArrayList<>(messagesMap.values());
	}

	public List<Message> getMessages(int year) {
		List<Message> filteredMessages = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Message message : messagesMap.values()) {
			calendar.setTime(message.getCreatedAt());
			if(calendar.get(Calendar.YEAR) == year)
				filteredMessages.add(message);
		}
		return filteredMessages;
	}

	public List<Message> getMessages(int start, int size) {
		List<Message> filteredMessages = new ArrayList<>(messagesMap.values());
		if((start + size) > filteredMessages.size())
			return new ArrayList<>();
		return filteredMessages.subList(start, start + size);
	}

	public Message getMessage(Long id) {
		return messagesMap.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messagesMap.size() + 1);
		messagesMap.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0)
			return null;
		messagesMap.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(Long id) {
		return messagesMap.remove(id);
	}
}
