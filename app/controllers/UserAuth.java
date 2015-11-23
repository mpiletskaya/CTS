package controllers;

import models.User;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by Maria on 11/22/15.
 */
public class UserAuth extends Security.Authenticator {

    //When return is null, that means authentication failed
    @Override
    public String getUsername(final Http.Context ctx){
        String userIdStr = ctx.session().get("user_id");
        if(userIdStr == null) return null;

        User user = User.find.byId(Long.parseLong(userIdStr));
        return (user != null ? user.id.toString() : null);
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx){
        ctx.flash().put("error",
                "Please, log in first!");
        return redirect(routes.Users.form());

    }
}
