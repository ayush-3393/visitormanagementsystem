package vms.visitormanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vms.visitormanagementsystem.dtos.HostRequestDto;
import vms.visitormanagementsystem.dtos.HostResponseDto;
import vms.visitormanagementsystem.models.Host;
import vms.visitormanagementsystem.services.HostService;

@RestController
@RequestMapping("/hosts")
public class HostController {
    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createHost(@RequestBody HostRequestDto hostRequestDto){
        try{
            Host host =
                    hostService.createHost(hostRequestDto.getName(),
                            hostRequestDto.getEmail(),
                            hostRequestDto.getPhone(),
                            hostRequestDto.getAddress());
            HostResponseDto hostResponseDto = new HostResponseDto();
            hostResponseDto.setName(host.getName());
            hostResponseDto.setEmail(host.getEmail());
            return ResponseEntity.ok(hostResponseDto);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
