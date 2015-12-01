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

    @Constraints.Required
    @Column(unique=true)
    public String email;

    @OneToMany
    public List<Tool> postedTools;
    //private String role; general user or admin;

    public static Finder<Long, User> find = new Finder<Long, User>(User.class);

    // NOT FOR PRODUCTION - must ensure this is a valid user first.
   public boolean authenticate(String password){
       return BCrypt.checkpw(password, this.passwordHash);
    }

    public static User createNewUser(String username,String password, String mail){
        if (password == null || mail == null || password.length() <8 ) {
            return null;
        }

        String pwHash = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User();
        user.email = mail;
        user.passwordHash = pwHash;
        if (username != null)
            user.username = username;
        
        return user;
    }

}
