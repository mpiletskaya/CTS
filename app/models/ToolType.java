package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Maria on 11/13/15.
 */

@Entity
public class ToolTypes extends Model {

    @Id
    private Long id;
    
    @Constraints.required
    public String typeName;
    
    public static Finder<Long, Tooltype> find = new Finder<Long, Tooltype>(Tooltype.class);
}
