package controllers;

import models.Tool;
import models.ToolType;
import models.Tool;
import models.User;
import play.data.Form;
import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class ToolTypes extends Controller {

    private List<ToolType> localToolType;

     // List all of the ToolType
     public Result index() {
        List<ToolType> tooltypes = ToolType.find.all();
        //TODO you don't have tooltypes folder in your views folder
        //return ok(views.html.tooltypes.index.render(tooltypes));
         return ok(views.html.ToolType.index.render(tooltypes));
     }
     
     public Result show(Long id) {
        ToolType Tooltype = ToolType.find.byId(id);
        if(Tooltype == null) {
            return notFound("not found");
        } else {
            List <Tool> tools = Tooltype.toolList;
            return ok(views.html.ToolType.show.render(Tooltype,tools));
           // return ok(views.html.tooltypes.show.render(Tooltype, tools));
        }
    }

    public Result form(){
        return ok(views.html.ToolType.form.render());
    }

    @Security.Authenticated(UserAuth.class)
    public Result create(){
        Form<ToolType> typeForm = Form.form(ToolType.class).bindFromRequest();

        User user = User.find.byId(Long.parseLong(session().get("user_id")));
        if (user.role.equals("admin")) {
            //TODO handle if user is null
            ToolType type = typeForm.get();

            type.save();
            flash("success", "Saved new Tool Category: " + type.typeName);
        }else{
            flash("error", "You have no privileges to perform this action");
        }
            //Create a new tool record in the db and redirect
            return redirect(routes.ToolTypes.index());
    }
}


