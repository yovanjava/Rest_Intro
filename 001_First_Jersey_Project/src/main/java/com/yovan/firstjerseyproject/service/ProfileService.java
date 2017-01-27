package com.yovan.firstjerseyproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yovan.firstjerseyproject.model.Profile;
import com.yovan.firstjerseyproject.util.DatabaseConnect;

public class ProfileService {

	private Map<String, Profile> profilesMap = DatabaseConnect.getProfiles();

	public ProfileService() {
		profilesMap.put("yovan", new Profile(1L, "Yovan", "Juggoo", "yovan", new Date(), "Avenue Surath, Quatre-Bornes"));
	}
	
	public List<Profile> getProfiles() {
		return new ArrayList<>(profilesMap.values());
	}
	
	public Profile getProfile(String profileName) {
		return profilesMap.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profilesMap.size() + 1);
		profilesMap.put(profile.getName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getName().isEmpty())
			return null;
		profilesMap.put(profile.getName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profilesMap.remove(profileName);
	}
}
