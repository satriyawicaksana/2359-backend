package com.satriya.app.entity;

import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.Map;

public class Shape {
    @Id
    private String _id;
    private String name;
    private int shapeid;
    private Map<String, Double>[] requirement;
    private int[] categories;
    private String[] area;

    public Shape() {
    }

    public Shape(String name, int shapeid, Map<String, Double>[] requirement, int[] categories, String[] area) {
        this.name = name;
        this.shapeid = shapeid;
        this.requirement = requirement;
        this.categories = categories;
        this.area = area;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShapeid() {
        return shapeid;
    }

    public void setShapeid(int shapeid) {
        this.shapeid = shapeid;
    }

    public Map<String, Double>[] getRequirement() {
        return requirement;
    }

    public void setRequirement(Map<String, Double>[] requirement) {
        this.requirement = requirement;
    }

    public int[] getCategories() {
        return categories;
    }

    public void setCategories(int[] categories) {
        this.categories = categories;
    }

    public String[] getArea() {
        return area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", requirement=" + Arrays.toString(requirement) +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }
}
