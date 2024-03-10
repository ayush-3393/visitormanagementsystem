package vms.visitormanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VisitorRequestDto {
    private String name;
    private String email;
    private String phone;
    private String address;
}
