package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Maria on 11/13/15.
 */

@Entity
public class ToolType extends Model {

    @Id
    private Long id;
    
    @Constraints.Required
    public String typeName;
    
    @OneToMany
    public List<Tool> toolList;

    i
    
    public static Finder<Long, ToolType> find = new Finder<Long, ToolType>(ToolType.class);


    public Boolean isTypeAvailable(){
       return toolList.size() > 0;
    }
}
