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
        return ok(views.html.index.render("Get all users"));
    }

    public Result form(){
        return ok(views.html.User.form.render("Create a new user"));
    }

    public Result signup(){

        DynamicForm userForm = Form.form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("pwd");
        //TODO deal with password confirmation field
       // String conf_password = userForm.data().get("pwd2");
        String email = userForm.data().get("email");

        User user = User.createNewUser(username, password, email);
        if(user == null) {
            flash("error", "Invalid user");
            return redirect(routes.Users.index());
        }
        user.save();
        flash("success", "Welcome new user " + user.username);
        session("user_id", user.id.toString());
        return redirect(routes.Users.index());
    }

    public Result login(){
        return ok(views.html.User.form.render("Login"));
    }
    public Result logout(){
        return ok(views.html.User.form.render("Logout"));
    }
    public Result delete(Long id){
        return ok(views.html.index.render("Delete a user and redirect"));
    }
    public Result show(Long id){
        return ok(views.html.index.render("Show a user profile"));
    }
    public Result edit(Long id){
        return ok(views.html.index.render("Edit a user"));
    }
    public Result update(Long id){
        return ok(views.html.index.render("Update a record about a user and redirect"));
    }
}
