package vms.visitormanagementsystem.services;

import org.springframework.stereotype.Service;
import vms.visitormanagementsystem.exceptions.VisitorAlreadyExistsException;
import vms.visitormanagementsystem.models.Visitor;
import vms.visitormanagementsystem.repositories.VisitorRepository;

import java.util.Optional;

// TODO : Create Test Cases for this service
@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor createVisitor(Visitor visitor) throws VisitorAlreadyExistsException {
        // check if the visitor with same email is already present in the db
        Optional<Visitor> visitorOptional = visitorRepository.findByEmail(visitor.getEmail());
        if (visitorOptional.isPresent()){
            throw new VisitorAlreadyExistsException("Visitor with email " + visitor.getEmail() + " already exists");
        }
        return visitorRepository.save(visitor);
    }

}
