package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Maria on 11/10/15.
 */
public class Users extends Controller {

    public Result index(){
        return ok(views.html.index.render("Get all users"));
    }

    public Result form(){
        return ok(views.html.index.render("Create a new user"));
    }

    public Result create(){
        return ok(views.html.index.render("Create a new user record in the db and redirect"));
    }

    public Result delete(Long id){
        return ok(views.html.index.render("Delete a user and redirect"));
    }
    public Result show(Long id){
        return ok(views.html.index.render("Show a user profile"));
    }
    public Result edit(Long id){
        return ok(views.html.index.render("Edit a user"));
    }
    public Result update(Long id){
        return ok(views.html.index.render("Update a record about a user and redirect"));
    }
}
