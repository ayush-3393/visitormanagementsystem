package vms.visitormanagementsystem.services;

import org.springframework.stereotype.Service;
import vms.visitormanagementsystem.dtos.EventRequestDto;
import vms.visitormanagementsystem.exceptions.EventAlreadyExistsException;
import vms.visitormanagementsystem.exceptions.HostDoesNotExistException;
import vms.visitormanagementsystem.models.Event;
import vms.visitormanagementsystem.models.Host;
import vms.visitormanagementsystem.repositories.EventRepository;
import vms.visitormanagementsystem.repositories.HostRepository;

import java.util.Optional;

// TODO : Create Test Cases for this service

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final HostRepository hostRepository;

    public EventService(EventRepository eventRepository, HostRepository hostRepository) {
        this.eventRepository = eventRepository;
        this.hostRepository = hostRepository;
    }

    public Event createEvent(EventRequestDto eventRequestDto) throws EventAlreadyExistsException, HostDoesNotExistException {
        // check if the event with same name and date already exists at the same location
        Optional<Event> eventOptional =
                eventRepository.
                        findEventByNameAndDateAndLocation(
                                eventRequestDto.getName(),
                                eventRequestDto.getDate(),
                                eventRequestDto.getLocation()
                        );

        if (eventOptional.isPresent()){
            throw new EventAlreadyExistsException(
                    "Event with name " + eventRequestDto.getName() + " already exists at the same location on the same date"
            );
        }

        // check if host does not exist
        Optional<Host> hostOptional = hostRepository.findById(eventRequestDto.getHostId());

        if (hostOptional.isEmpty()){
            throw new HostDoesNotExistException("Host with id " + eventRequestDto.getHostId() + " does not exist");
        }

        Event event = new Event();
        event.setName(eventRequestDto.getName());
        event.setDate(eventRequestDto.getDate());
        event.setLocation(eventRequestDto.getLocation());
        event.setDescription(eventRequestDto.getDescription());
        event.setHost(hostOptional.get());
        event.setVisitors(eventRequestDto.getVisitors());

        return eventRepository.save(event);
    }

}
