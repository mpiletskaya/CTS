package controllers;

import models.Review;
import models.Tool;
import models.ToolType;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import java.util.ArrayList;
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
        List <ToolType> allTypes = ToolType.find.all();

        return ok(views.html.Tool.form.render(allTypes));
    }

    @Security.Authenticated(UserAuth.class)
    public Result borrow(Long id){
        Tool t = Tool.find.byId(id);
        t.status = 0;
        User owner = t.owner;
        User uBorrower = User.find.byId(Long.parseLong(session("user_id")));
//        t.borrower = uBorrower;
        t.update();
        return redirect(routes.Tools.show(id));
    }

    @Security.Authenticated(UserAuth.class)
    public Result create(){
        Form<Tool> toolForm = Form.form(Tool.class).bindFromRequest();
        String tooltypeId = toolForm.data().get("tooltype_id");
        ToolType t = ToolType.find.byId(Long.parseLong(tooltypeId));
        if(t == null) {
            flash("error", "Invalid : " + tooltypeId + " Try again.");
            return redirect(routes.Tools.index());
        }
        User user = User.find.byId(Long.parseLong(session().get("user_id")));
        //TODO handle if user is null
        Tool tool = toolForm.get();
        tool.owner = user;
        tool.tType = t;
        tool.status = 1;
        tool.save();
        flash("success", "Saved new Tool: " + tool.name + tool.owner.username);
        //Create a new tool record in the db and redirect
        return redirect(routes.Tools.index());
    }

    public Result delete(Long id){
        return ok(views.html.index.render("Delete a tool and redirect"));
    }
    public Result show(Long id){
        List<Review> reviews;
        Tool t = Tool.find.byId(id);
        if (t.reviews!= null) {
            reviews = t.reviews;
        }else{
            reviews = new ArrayList<Review>();;
        }
        return ok(views.html.Tool.show.render(t,reviews));
    }
    public Result edit(Long id){
        return ok(views.html.index.render("Edit a tool"));
    }
    public Result update(Long id){
        return ok(views.html.index.render("Update a record about tool and redirect"));
    }
}
