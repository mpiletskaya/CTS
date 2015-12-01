package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Maria on 12/1/15.
 */

@Entity
public class Review {
    @Id
    public Long id;
    @Constraints.Required //TODO check import
    public String body;

    public String timeCreated;
    public Long user_id;
    public Long tool_id;


}
