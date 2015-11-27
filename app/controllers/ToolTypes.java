package controllers;

import models.Tooltype;
import mdoels.Tool;
import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.list;

public class ToolTypes extends Controller {

     // List all of the ToolType
     public Result index() {
        List<Tooltype> tooltypes = Tooltype.findall();
        return ok(views.html.tooltypes.index.render(tooltypes));
     }
     
     public Result show(Long id) {
        Tooltype Tooltype = Tooltype.find.byId(id);
        if(genre == null) {
            return notFound("not found");
        } else {
            List<Tool> tools = tooltype.toolList;
            return ok(views.html.tooltypes.show.render(tooltype, tools));
        }
    }

}
