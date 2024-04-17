package com.infs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.infs.document.PropertyDocument;

public interface PropertyRepo extends MongoRepository<PropertyDocument, Integer>{

}
