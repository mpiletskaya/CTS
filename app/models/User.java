package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Maria on 11/13/15.
 */

@Table(name="users")
@Entity
public class User extends Model{

    @Id
    private Long id;

    private String username;
    private String passwordHash;
    @Constraints.Required
    private String email;
    //private String role; general user or admin;

    public static Finder<Long, User> find = new Finder<Long, User>(User.class);
}
