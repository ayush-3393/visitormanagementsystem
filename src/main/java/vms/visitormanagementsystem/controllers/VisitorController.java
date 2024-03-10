package vms.visitormanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vms.visitormanagementsystem.dtos.VisitorRequestDto;
import vms.visitormanagementsystem.dtos.VisitorResponseDto;
import vms.visitormanagementsystem.models.Visitor;
import vms.visitormanagementsystem.services.VisitorService;
import vms.visitormanagementsystem.utility.ConvertDtoToEntity;

// TODO : Write Test Cases

@RestController
@RequestMapping("/visitor")
public class VisitorController {
    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVisitor(@RequestBody VisitorRequestDto visitorRequestDto){
        Visitor visitor = ConvertDtoToEntity.convertVisitorDtoToEntity(visitorRequestDto);
        try {
            Visitor savedVisitor = visitorService.createVisitor(visitor);
            VisitorResponseDto response = new VisitorResponseDto();
            response.setName(savedVisitor.getName());
            response.setEmail(savedVisitor.getEmail());
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
