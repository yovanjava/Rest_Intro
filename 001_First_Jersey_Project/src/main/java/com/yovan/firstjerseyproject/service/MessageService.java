package com.yovan.firstjerseyproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yovan.firstjerseyproject.model.Message;

public class MessageService {

	public static List<Message> getMessages() {
		List<Message> messagesList = new ArrayList<>();
		messagesList.add(new Message(1, "Hello World!", "john", new Date()));
		messagesList.add(new Message(1, "Hello Jersey!", "jack", new Date()));
		return messagesList;
	}
}
