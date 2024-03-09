package vms.visitormanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vms.visitormanagementsystem.models.Event;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventByNameAndDateAndLocation(String name, Date date, String location);
}
