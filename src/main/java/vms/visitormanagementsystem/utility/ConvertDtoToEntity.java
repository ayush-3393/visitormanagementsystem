package vms.visitormanagementsystem.utility;

import vms.visitormanagementsystem.dtos.VisitorRequestDto;
import vms.visitormanagementsystem.models.Visitor;

public class ConvertDtoToEntity {

    public static Visitor convertVisitorDtoToEntity(VisitorRequestDto visitorRequestDto){
        Visitor visitor = new Visitor();
        visitor.setName(visitorRequestDto.getName());
        visitor.setEmail(visitorRequestDto.getEmail());
        visitor.setPhone(visitorRequestDto.getPhone());
        visitor.setAddress(visitorRequestDto.getAddress());
        return visitor;
    }

}
