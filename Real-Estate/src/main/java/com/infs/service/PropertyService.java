package com.infs.service;

import java.util.List;

import com.infs.dto.Property;

public interface PropertyService {

	public List<Property> viewAllProperties();
	
	public Property addProperty(Property property);
	
	public Property getPropertyById(int id);
	
	public Property updateProperty(int id, Property property);
	
	public boolean removeProperty(int id);
}
