package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    public Long tool_id;
    //TODO  store id or object?
    @ManyToOne
    public Long user_id;
    //vs
    @ManyToOne
    public User user;






}
