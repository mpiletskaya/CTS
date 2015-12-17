package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Maria on 11/8/15.
 */

@Entity
public class Tool extends Model {

    @Id
    public Long id;
    @Constraints.Required
    public String name;
    @Constraints.Required
    public String description;
    public String status;
    @ManyToOne
    public ToolType tType;
    @ManyToOne
    public User owner;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Review> reviews;

    public static Finder<Long, Tool> find = new Finder<Long, Tool>(Tool.class);

}