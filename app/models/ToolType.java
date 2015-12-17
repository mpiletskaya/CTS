package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Maria on 11/13/15.
 */

@Entity
public class ToolType extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String typeName;

    public String typeImageURL;

    public String section;
    public String description;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Tool> toolList;

    @Transient
    private Boolean availability;
    
    public static Finder<Long, ToolType> find = new Finder<Long, ToolType>(ToolType.class);

    public Boolean getAvailability() {
        return toolList.size() > 0;
    }



}
