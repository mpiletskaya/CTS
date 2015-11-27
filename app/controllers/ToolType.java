package controllers;

import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;

public class ToolTypes extends Controller {

     // List all of the ToolType
    public Result index() {
        return ok("ToolType list");
    }

    public Result create() {
        return redirect(routes.ToolType.index());
    }

}
