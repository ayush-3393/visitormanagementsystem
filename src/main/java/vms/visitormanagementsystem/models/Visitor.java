package vms.visitormanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "visitors")
public class Visitor extends BaseModel{
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date entryTime;
    private Date exitTime;
    @ManyToMany
    private List<Event> events;
}
