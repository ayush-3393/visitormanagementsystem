package vms.visitormanagementsystem.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import vms.visitormanagementsystem.exceptions.HostAlreadyExistsException;
import vms.visitormanagementsystem.models.Host;
import vms.visitormanagementsystem.repositories.HostRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HostServiceTest {

    @Autowired
    private HostService hostService;

    @MockBean
    private HostRepository hostRepository;

    @Test
    void createHostThrowsAlreadyExistExceptionWhenSameEmailIsFound() {
        Host host = new Host();
        host.setEmail("abc@gmail.com");
        when(hostRepository.findHostByEmail("abc@gmail.com")).thenReturn(Optional.of(host));

        assertThrows(
                HostAlreadyExistsException.class,
                () -> {
                    hostService.createHost("name", "abc@gmail.com", "1234567890", "address");
                }
        );
    }

    @Test
    void createHostCreatesANewHostWithUniqueEmailAddress() {
        when(hostRepository.findHostByEmail("abc@gmail.com")).thenReturn(Optional.empty());

        Host newHost = new Host();
        newHost.setEmail("abc@gmail.com");
        when(hostRepository.save(any(Host.class))).thenReturn(newHost);

        Host createdHost = null;

        try {
            createdHost =
                    hostService.createHost("name", "abc@gmail.com", "1234567890", "address");
        }
        catch (HostAlreadyExistsException e) {
            fail("Should not throw HostAlreadyExistsException");
        }

        assertNotNull(createdHost);
        assertEquals("abc@gmail.com", createdHost.getEmail());
    }

}