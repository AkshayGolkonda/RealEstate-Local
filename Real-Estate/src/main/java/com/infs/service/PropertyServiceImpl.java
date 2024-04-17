package com.infs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infs.document.PropertyDocument;
import com.infs.dto.Property;
import com.infs.repository.PropertyRepo;

@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
    PropertyRepo repo;
	
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<Property> viewAllProperties() {
		List<PropertyDocument> propertyDocuments=repo.findAll();
		List<Property> properties=new ArrayList<>();
		for(PropertyDocument document:propertyDocuments) {
			properties.add(convertPropertyDocumentIntoDto(document));
		}
		return properties;
	}


	@Override
	public Property addProperty(Property property) {
		PropertyDocument propertyDocument = convertPropertyDtoIntoDocument(property);
		repo.save(propertyDocument);
		return convertPropertyDocumentIntoDto(propertyDocument);
	}


	@Override
	public Property getPropertyById(int id) {
		Optional<PropertyDocument> optionalProperty=repo.findById(id);
        if(optionalProperty.isPresent()){
            return convertPropertyDocumentIntoDto(optionalProperty.get());
        }
        return null;
	}


	@Override
	public Property updateProperty(int id, Property property) {
		Optional<PropertyDocument> optionalProperty=repo.findById(id);
        if(optionalProperty.isPresent()){
            PropertyDocument updateProperty=optionalProperty.get();
            updateProperty.setPrice(property.getPrice());
            updateProperty.setDesc(property.getDesc());
            updateProperty.setZipcode(property.getZipcode());
            updateProperty.setAddress(property.getAddress());
            repo.save(updateProperty);
            return convertPropertyDocumentIntoDto(updateProperty);
        }
        return null;
	}


	@Override
	public boolean removeProperty(int id) {
		 
		 if(repo.existsById(id)) {
			 repo.deleteById(id);
			 return true;
		 }
		 return false;
	}
	
	
	private Property convertPropertyDocumentIntoDto(PropertyDocument propertyDocument) {
		Property property = modelMapper.map(propertyDocument, Property.class);
		return property;
	}
	
	private PropertyDocument convertPropertyDtoIntoDocument(Property property) {
		PropertyDocument propertyDocument = modelMapper.map(property, PropertyDocument.class);
		return propertyDocument;
	}

}
