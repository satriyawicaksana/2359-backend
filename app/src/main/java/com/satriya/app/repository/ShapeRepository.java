package com.satriya.app.repository;

import com.satriya.app.entity.Shape;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepository extends MongoRepository<Shape, String> {
    public Shape findByName(String name);
    public Shape findByShapeid(int shapeid);
}
