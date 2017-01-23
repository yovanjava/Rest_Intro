package com.yovan.firstjerseyproject.util;

import java.util.HashMap;
import java.util.Map;

import com.yovan.firstjerseyproject.model.Message;
import com.yovan.firstjerseyproject.model.Profile;

public class DatabaseConnect {

	private static Map<Long, Message> messagesMap = new HashMap<>();
	private static Map<Long, Profile> profilesMap = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messagesMap;
	}

	public static Map<Long, Profile> getProfiles() {
		return profilesMap;
	}

}
