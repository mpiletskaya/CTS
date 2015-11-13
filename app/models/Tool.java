package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Maria on 11/8/15.
 */

@Entity
public class Tool extends Model {

    @Id
    private Long id;

    private String name;
    private String description;
    //private Long owner_id;
}