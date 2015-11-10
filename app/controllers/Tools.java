package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Maria on 11/10/15.
 */
public class Tools extends Controller{
    public Result index(){
        return ok(views.html.index.render("Ready!"));
    }

    public Result form(){
        return ok(views.html.index.render("Create a new tool"));
    }

    public Result create(){
        return ok(views.html.index.render("Create a new tool record in the db and redirect"));
    }

    public Result delete(Long id){
        return ok(views.html.index.render("Delete a tool and redirect"));
    }
    public Result show(Long id){
        return ok(views.html.index.render("Show a tool"));
    }
    public Result edit(Long id){
        return ok(views.html.index.render("Edit a tool"));
    }
    public Result update(Long id){
        return ok(views.html.index.render("Update a record about tool and redirect"));
    }
}
