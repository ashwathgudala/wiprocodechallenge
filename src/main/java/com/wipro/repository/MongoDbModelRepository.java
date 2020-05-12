package com.wipro.repository;

import com.wipro.model.MongoDbModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbModelRepository extends MongoRepository<MongoDbModel,Long> {


}
