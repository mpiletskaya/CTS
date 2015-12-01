package controllers;

import models.ToolType;
import models.Tooltype;
import mdoels.Tool;
import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.list;

public class ToolTypes extends Controller {

     // List all of the ToolType
     public Result index() {
        List<ToolType> tooltypes = ToolType.find.all();
        //TODO you don't have toltypes folder in your views folder
        return ok(views.html.tooltypes.index.render(tooltypes));
     }
     
     public Result show(Long id) {
        ToolType Tooltype = ToolType.find.byId(id);
        if(Tooltype == null) {
            return notFound("not found");
        } else {
            List<Tool> tools = tooltype.toolList;
            return ok(views.html.tooltypes.show.render(tooltype, tools));
        }
    }

}
