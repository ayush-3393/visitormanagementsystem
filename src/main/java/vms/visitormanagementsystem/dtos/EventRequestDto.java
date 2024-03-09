package vms.visitormanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;
import vms.visitormanagementsystem.models.Visitor;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class EventRequestDto {
    private String name;
    private Date date;
    private String location;
    private String description;
    private Long hostId;
    private List<Visitor> visitors;
}
