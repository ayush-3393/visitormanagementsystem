package vms.visitormanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "hosts")
public class Host extends BaseModel{
    private String name;
    private String email;
    private String phone;
    private String address;
    @OneToMany(mappedBy = "host")
    private List<Event> events;
}
