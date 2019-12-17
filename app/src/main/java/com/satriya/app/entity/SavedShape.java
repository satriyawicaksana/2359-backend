package com.satriya.app.entity;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class SavedShape {
    @Id
    String _id;
    String userid;
    String name;
    int shapeid;
    Map<String, Double> requirement;
    double area;
    int[] categories;
    String[] categoriesString;

    public SavedShape() {
    }

    public SavedShape(String userid, String name, int shapeid, Map<String, Double> requirement, double area, int[] categories, String[] categoriesString) {
        this.userid = userid;
        this.name = name;
        this.shapeid = shapeid;
        this.requirement = requirement;
        this.area = area;
        this.categories = categories;
        this.categoriesString = categoriesString;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public Map<String, Double> getRequirement() {
        return requirement;
    }

    public void setRequirement(Map<String, Double> requirement) {
        this.requirement = requirement;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int[] getCategories() {
        return categories;
    }

    public void setCategories(int[] categories) {
        this.categories = categories;
    }

    public String[] getCategoriesString() {
        return categoriesString;
    }

    public void setCategoriesString(String[] categoriesString) {
        this.categoriesString = categoriesString;
    }
}
