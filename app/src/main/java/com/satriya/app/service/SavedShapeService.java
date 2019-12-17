package com.satriya.app.service;

import com.satriya.app.entity.SavedShape;
import com.satriya.app.repository.SavedShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedShapeService {
    @Autowired
    private SavedShapeRepository savedShapeRepository;

    public void addNewShape(SavedShape savedShape){
        this.savedShapeRepository.save(savedShape);
    }

    public List<SavedShape> getAllSavedShapes() {
        return this.savedShapeRepository.findAll();
    }

    public List<SavedShape> adminGetAllUserShapeById(String kidsId) {
        return this.savedShapeRepository.findByUserid(kidsId);
    }

    public void adminAddUserShapeById(SavedShape savedShape) {
        this.savedShapeRepository.save(savedShape);
    }

    public void adminUpdateUserShapeById(String shapeId, SavedShape savedShape) {
        Optional<SavedShape> s = this.savedShapeRepository.findById(shapeId);
        s.get().setArea(savedShape.getArea());
        s.get().setCategories(savedShape.getCategories());
        s.get().setCategoriesString(savedShape.getCategoriesString());
        s.get().setName(savedShape.getName());
        s.get().setRequirement(savedShape.getRequirement());
        s.get().setShapeid(savedShape.getShapeid());
        s.get().setUserid(savedShape.getUserid());
        this.savedShapeRepository.save(s.get());
    }

    public void adminDeleteUserShapeById(String shapeId) {
        this.savedShapeRepository.deleteById(shapeId);
    }

}
