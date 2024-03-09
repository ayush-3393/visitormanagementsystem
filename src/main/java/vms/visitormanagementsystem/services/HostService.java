package vms.visitormanagementsystem.services;

import org.springframework.stereotype.Service;
import vms.visitormanagementsystem.exceptions.HostAlreadyExistsException;
import vms.visitormanagementsystem.models.Host;
import vms.visitormanagementsystem.repositories.HostRepository;

import java.util.Optional;

@Service
public class HostService {

    private final HostRepository hostRepository;

    public HostService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public Host createHost(String name, String email, String phone, String address) throws HostAlreadyExistsException {

        Optional<Host> hostOptional = hostRepository.findHostByEmail(email);

        if (hostOptional.isPresent()){
            throw new HostAlreadyExistsException("Host with email " + email + " already exists");
        }

        Host host = new Host();

        host.setName(name);
        host.setEmail(email);
        host.setPhone(phone);
        host.setAddress(address);
        return hostRepository.save(host);
    }
}
