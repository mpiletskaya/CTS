package controllers;

import models.Tool;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.List;

/**
 * Created by Maria on 11/10/15.
 */
public class Tools extends Controller{
    public Result index(){
        List<Tool> tools = Tool.find.all();
       
        return ok(views.html.Tool.index.render(tools));
    }

    public Result form(){
        return ok(views.html.Tool.form.render("Create a new tool"));
    }

    @Security.Authenticated(UserAuth.class)
    public Result create(){
        Tool tool = Form.form(Tool.class).bindFromRequest().get();
        tool.save();
        flash("success", "Saved new Tool: " + tool.name);
        //Create a new tool record in the db and redirect
        return redirect(routes.Tools.index());
    }

    public Result delete(Long id){
        return ok(views.html.index.render("Delete a tool and redirect"));
    }
    public Result show(Long id){
        Tool t = Tool.find.byId(id);
        return ok(views.html.Tool.show.render(t));
    }
    public Result edit(Long id){
        return ok(views.html.index.render("Edit a tool"));
    }
    public Result update(Long id){
        return ok(views.html.index.render("Update a record about tool and redirect"));
    }
}
