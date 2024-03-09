package vms.visitormanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vms.visitormanagementsystem.models.Visitor;
@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
