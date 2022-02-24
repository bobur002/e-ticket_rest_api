package uz.pdp.eticket_rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticket_model.dto.receive.PassengerReceiveDto;
import uz.pdp.eticket_model.dto.receive.TicketReceiveDto;
import uz.pdp.eticket_rest_api.service.PassengerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/passenger")
public class PassengerController {
    private final PassengerService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PassengerReceiveDto passengerReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(passengerReceiveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(service.getpassenger(id));
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(service.getPassengers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
