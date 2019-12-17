package com.satriya.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.satriya.app.entity.SavedShape;
import com.satriya.app.entity.Shape;
import com.satriya.app.repository.ShapeRepository;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;

@Service
public class ShapeService {
    @Autowired
    private ShapeRepository shapeRepository;

    public List<Shape> getAllShape(){
        return this.shapeRepository.findAll();
    }

    public Optional getShapeById(String id) {
        return this.shapeRepository.findById(id);
    }

    public String calculateArea(String string) throws JsonProcessingException {

        /**
         * Input format :
         * ex.
         *      {
         * 	        "shapeid": 2,
         * 	        "requirement": {
         *              "size": 14.0
         *          }
         *      }
         *
         * Output format:
         * ex.
         *  {
         *      "area":196.0,
         *      "categories":[
         *          "rectangle",
         *          "parallelogram",
         *          "trapezium"
         *      ]
         *  }
         *
         * */
        ObjectMapper om = new ObjectMapper();
        SavedShape s = om.readValue(string, SavedShape.class);
        double area = 0;
        if(s.getShapeid() == 1){
            double width = s.getRequirement().get("width");
            double height = s.getRequirement().get("height");
            area = width * height;
        }
        else if(s.getShapeid() == 2){
            double size = s.getRequirement().get("size");
            area = Math.pow(size, 2);
        }
        else if(s.getShapeid() == 3){
            double base = s.getRequirement().get("base");
            double height = s.getRequirement().get("height");
            area = base * height / 2;
        }
        else if(s.getShapeid() == 4){
            double base = s.getRequirement().get("base");
            double height = s.getRequirement().get("height");
            area = base * height;
        }
        else if(s.getShapeid() == 5 || s.getShapeid() == 6){
            double diagonal1 = s.getRequirement().get("diagonal1");
            double diagonal2 = s.getRequirement().get("diagonal2");
            area = diagonal1 * diagonal2 / 2;
        }
        else if(s.getShapeid() == 7){
            double base1 = s.getRequirement().get("base1");
            double base2 = s.getRequirement().get("base2");
            double height = s.getRequirement().get("height");
            area = (base1 + base2) * height / 2;
        }
        else if(s.getShapeid() == 7){
            double base1 = s.getRequirement().get("base1");
            double base2 = s.getRequirement().get("base2");
            double height = s.getRequirement().get("height");
            area = (base1 + base2) * height / 2;
        }
        else if(s.getShapeid() == 8 || s.getShapeid() == 9){
            if(s.getRequirement().get("radius") != null) {
                double radius = s.getRequirement().get("radius");
                area = Math.PI * Math.pow(radius,2);
            }
            if(s.getRequirement().get("diameter") != null){
                double diameter = s.getRequirement().get("diameter");
                area = Math.PI / 4 * Math.pow(diameter, 2);
            }
            if(s.getRequirement().get("circumference") != null){
                double circumference = s.getRequirement().get("circumference");
                area = Math.pow(circumference, 2) / 4 * Math.PI;
            }
        }
        /**
         * get categories
         * */
        int[] array = this.shapeRepository.findByShapeid(s.getShapeid()).getCategories();
        String[] categories = new String[array.length];
        for(int i = 0; i < categories.length; i++){
            categories[i] = this.shapeRepository.findByShapeid(array[i]).getName();
        }
        /**
         * get name
         * */
        String name = this.shapeRepository.findByShapeid(s.getShapeid()).getName();

        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("shapeid", s.getShapeid());
        result.put("requirement", s.getRequirement());
        result.put("area", area);
        result.put("categories", array);
        result.put("categoriesString", categories);
        String json = new ObjectMapper().writeValueAsString(result);
        return json;
    }

    public boolean editShape(String shapeId, Shape shape) {
        Optional<Shape> s = this.shapeRepository.findById(shapeId);
        if(s.isPresent()){
            s.get().setName(shape.getName());
            s.get().setArea(shape.getArea());
            s.get().setCategories(shape.getCategories());
            s.get().setRequirement(shape.getRequirement());
            this.shapeRepository.save(s.get());
            return true;
        }
        else {
            return  false;
        }
    }
}
