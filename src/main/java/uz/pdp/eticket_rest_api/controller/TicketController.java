package uz.pdp.eticket_rest_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticket_model.dto.receive.TicketReceiveDto;
import uz.pdp.eticket_model.dto.receive.UserReceiveDto;
import uz.pdp.eticket_rest_api.service.TicketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TicketReceiveDto ticketReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.add(ticketReceiveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(ticketService.getTicket(id));
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(ticketService.getTickets());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        ticketService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
