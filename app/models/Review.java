package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Maria on 12/1/15.
 */

@Entity
public class Review extends Model{
    @Id
    public Long id;
    @Constraints.Required
    public String body;
    public String timeCreated;

    @ManyToOne
    public User user;
    @ManyToOne
    public Tool tool;

    public static Model.Finder<Long, Review> find = new Model.Finder<Long, Review>(Review.class);




}
