package uz.pdp.eticket_rest_api.repository.sql.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_rest_api.repository.sql.repository.PassengerRepository;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;
}
