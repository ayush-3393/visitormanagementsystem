package vms.visitormanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "events")
public class Event extends BaseModel {
    private String name;
    private Date date;
    private String location;
    private String description;
    @ManyToOne
    private Host host;
    @ManyToMany(mappedBy = "events")
    private List<Visitor> visitors;
}
