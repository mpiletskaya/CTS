package controllers;

import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Maria on 11/10/15.
 */
public class Users extends Controller {

    public Result index(){
        return ok(views.html.index.render(""));
    }

    public Result form(){
        return ok(views.html.User.form.render("Create a new user"));
    }

    public Result signup(){

        DynamicForm userForm = Form.form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("pwd");
        String conf_pass = userForm.data().get("pwd2");
        if (!password.equals(conf_pass)) {
            flash("error", "Your passwords do not match");
            return redirect(routes.Users.form());
        }else {
            String email = userForm.data().get("email");

            User user = User.createNewUser(username, password, email);
            if (user == null) {
                flash("error", "Invalid user");
                return redirect(routes.Users.form());
            }
            user.save();
            flash("success", "Welcome new user " + user.username);
            session("user_id", user.id.toString());
            return redirect(routes.Tools.index());
        }

    }

    public Result login(){
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        String email = dynamicForm.data().get("email");
        String password = dynamicForm.data().get("pwd");
        User user = User.find.where().eq("email", email).findUnique();
        if(user != null && user.authenticate(password)) {
            session("user_id", user.id.toString());
            flash("success", "Welcome back " + user.username);
        } else {
            flash("error", "Invalid login. Check your username and password.");
        }
        return redirect(routes.Tools.create());
    }
    public Result logout(){
        session().remove("user_id");
        return redirect(routes.Tools.index());
    }
    public Result delete(Long id){
        User user = User.find.byId(id);
        if (user!=null){
            session().remove("user_id");
            user.delete();
        }else{
            flash("Error", "Sorry, something went wrong.Please, try again later");
        }
        return redirect(routes.Tools.index());
    }
    public Result show(Long id){
        User user = User.find.byId(id);
        return ok(views.html.User.show.render(user));
    }
    public Result edit(Long id){
        User user = User.find.byId(id);
        return ok(views.html.User.edit.render(user));
    }
    public Result update(Long id){
        return ok(views.html.index.render("Update a record about a user and redirect"));
    }
}
