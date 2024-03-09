package vms.visitormanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EventResponseDto {
    private String name;
    private Date date;
    private String location;
}
