package controllers;

import models.Tooltype;
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
