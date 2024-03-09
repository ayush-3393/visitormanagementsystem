package vms.visitormanagementsystem.controllers;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vms.visitormanagementsystem.dtos.EventRequestDto;
import vms.visitormanagementsystem.dtos.EventResponseDto;
import vms.visitormanagementsystem.models.Event;
import vms.visitormanagementsystem.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("{hostId}/create")
    public ResponseEntity<?> createEvent(@PathVariable Long hostId, @RequestBody EventRequestDto eventRequestDto){

        try{
            eventRequestDto.setHostId(hostId);
            Event event = eventService.createEvent(eventRequestDto);
            EventResponseDto responseDto = new EventResponseDto();
            responseDto.setName(event.getName());
            responseDto.setDate(event.getDate());
            responseDto.setLocation(event.getLocation());
            return ResponseEntity.ok(responseDto);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
