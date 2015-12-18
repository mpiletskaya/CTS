package models;

import com.avaje.ebean.Model;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Maria on 11/13/15.
 */

@Table(name="users")
@Entity
public class User extends Model{

    @Id
    public Long id;

    public String username;
    public String passwordHash;
    public String zipcode;

    public String lname;
    public String fname;

    @Constraints.Required
    @Column(unique=true)
    public String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    @JoinColumn(name = "tool_id", referencedColumnName = "id")
    public List<Tool> postedTools;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "borrower")
    @JoinColumn(name = "tool_id", referencedColumnName = "id")
    public List<Tool> borrowedTools;
    //general user or admin;
    public String role;

    public static Finder<Long, User> find = new Finder<Long, User>(User.class);

    // NOT FOR PRODUCTION - must ensure this is a valid user first.
   public boolean authenticate(String password){
       return BCrypt.checkpw(password, this.passwordHash);
    }

    public static User createNewUser(String username,String password, String mail,String zip){
        if (password == null || mail == null || password.length() <8 ) {
            return null;
        }

        String pwHash = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User();
        user.email = mail;
        user.passwordHash = pwHash;
        user.zipcode = zip;

        if (username != null)
            user.username = username;
        user.role = username.equals("admin") ?  "admin" : "general";

        return user;
    }

}
