package controllers;

import models.Review;
import models.Tool;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.List;

/**
 * Created by Maria on 12/15/15.
 */
public class Reviews extends Controller {

    @Security.Authenticated(UserAuth.class)
    public Result create(Long toolId){
        Form<Review> typeForm = Form.form(Review.class).bindFromRequest();

        User user = User.find.byId(Long.parseLong(session().get("user_id")));
        Tool t = Tool.find.byId(toolId);
        if (user == null) {
            flash("error", "please login first");
        }else{
            Review r = typeForm.get();
            r.user = user;
            r.tool = t;
            r.save();
        }
        //Create a new review record in the db and redirect
        return redirect(routes.Tools.show(toolId));
    }
}
