package com.satriya.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.satriya.app.entity.SavedShape;
import com.satriya.app.entity.Shape;
import com.satriya.app.entity.User;
import com.satriya.app.service.SavedShapeService;
import com.satriya.app.service.ShapeService;
import com.satriya.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ShapeController {
    @Autowired
    private ShapeService shapeService;

    @Autowired
    private SavedShapeService savedShapeService;

    @Autowired
    private UserService userService;

    /** BASIC REQUIREMENT
     *  API to list all the shapes, and its requirement sets and so on
     * */
    @GetMapping(path = "/shapes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Shape> getAllShape(){
        System.out.println("/shapes GET Request");
        return this.shapeService.getAllShape();
    }

    /** Challenging REQUIREMENT
     *  API to manage shape categories and Name, Requirement, Area Formula
     * */
    @PutMapping(path = "/shapes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public boolean editShapes(@PathVariable("id")String shapeId, @RequestBody Shape shape){
        return this.shapeService.editShape(shapeId, shape);
    }

    /** ******* REQUIREMENT
     *
     * */
    @GetMapping(path = "/shapes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional getShapeById(@PathVariable("id") String id){
        return this.shapeService.getShapeById(id);
    }

    /** BASIC REQUIREMENT
     *  API to submit the shape, returning with area and possible categories
     * */
    @GetMapping(path = "/shapes/calculate",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String calculateArea(@RequestBody String string) throws JsonProcessingException {
        return this.shapeService.calculateArea(string);
    }

    /** BASIC REQUIREMENT
     *  API to save the shape
     * */
    @PostMapping(path = "/shapes/calculate")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewShape(@RequestBody SavedShape savedShape){
        this.savedShapeService.addNewShape(savedShape);
    }

    /** BASIC REQUIREMENT
     *  API to list all saved shapes
     * */
    @GetMapping(path = "/shapes/saved")
    @ResponseStatus(HttpStatus.OK)
    public List<SavedShape> getAllSavedShapes(){
        // later change into get with user id
        return this.savedShapeService.getAllSavedShapes();
    }

    /** INTERMEDIATE REQUIREMENT
     *  API CMS Admin for list shapes for each kids
     * */
    @GetMapping(path = "/shapes/saved/{kidsId}")
    @ResponseStatus(HttpStatus.OK)
    public List<SavedShape> adminGetAllUserShapeById(@PathVariable("kidsId") String kidsId){
        return this.savedShapeService.adminGetAllUserShapeById(kidsId);
    }

    /** INTERMEDIATE REQUIREMENT
     *  API CMS Admin for list shapes for each kids
     * */
    @PostMapping(path = "/shapes/saved")
    @ResponseStatus(HttpStatus.CREATED)
    public void adminAddUserShapeById(@RequestBody SavedShape savedShape){
        this.savedShapeService.adminAddUserShapeById(savedShape);
    }

    /** INTERMEDIATE REQUIREMENT
     *  API CMS Admin for list shapes for each kids
     * */
    @PutMapping(path = "/shapes/saved/{shapeId}")
    @ResponseStatus(HttpStatus.OK)
    public void adminUpdateUserShapeById(@PathVariable("shapeId") String shapeId, @RequestBody SavedShape savedShape){
        this.savedShapeService.adminUpdateUserShapeById(shapeId, savedShape);
    }

    /** INTERMEDIATE REQUIREMENT
     *  API CMS Admin for list shapes for each kids
     * */
    @DeleteMapping(path = "/shapes/saved/{shapeId}")
    @ResponseStatus(HttpStatus.OK)
    public void adminDeleteUserShapeById(@PathVariable("shapeId") String shapeId){
        this.savedShapeService.adminDeleteUserShapeById(shapeId);
    }

    /** INTERMEDIATE REQUIREMENT
     *  User can sign up
     * */
    @PostMapping(path = "/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void userSignUp(@RequestBody User user){
        this.userService.userSignUp(user);
    }

    /** INTERMEDIATE REQUIREMENT
     *  admin can sign up
     * */
    @PostMapping(path = "/admin/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void adminSignUp(@RequestBody User user){
        this.userService.adminSignup(user);
    }

    /** INTERMEDIATE REQUIREMENT
     *  admin can delete
     * */
    @DeleteMapping(path = "/admin/delete/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void adminDelete(@PathVariable("userId") String userId){
        this.userService.adminDelete(userId);
    }


    /** INTERMEDIATE REQUIREMENT
     *  User can sign in
     * */
    @PostMapping(path = "/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean userSignIn(@RequestBody User user){
        return this.userService.userSignIn(user);
    }


    /** ADDITIONAL
     *  I assume that always be a username checker in frontend
     *  this function is to check available username in future development
     * */
    @PostMapping(path="/checkUser")
    @ResponseStatus(HttpStatus.OK)
    public boolean uniqueUsername(@RequestBody String username){
        System.out.println(username);
        if (this.userService.uniqueUsername(username))
            return true;
        else
            return false;

    }

}
