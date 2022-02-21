package uz.pdp.eticket_rest_api.repository.sql.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_rest_api.repository.sql.repository.TicketRepository;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

}
