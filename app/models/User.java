package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Maria on 11/13/15.
 */

@Entity
public class User extends Model{

    @Id
    private Long id;

    private String username;
    private String password;
    private String email;
    //private String role; general user or admin;
}
