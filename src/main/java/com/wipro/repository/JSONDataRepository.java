package com.wipro.repository;

import com.wipro.model.JSONData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JSONDataRepository extends MongoRepository<JSONData,Long> {


}
