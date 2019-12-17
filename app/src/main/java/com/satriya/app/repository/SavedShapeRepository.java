package com.satriya.app.repository;

import com.satriya.app.entity.SavedShape;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedShapeRepository extends MongoRepository<SavedShape, String> {
    public List<SavedShape> findByUserid(String userId);
}
