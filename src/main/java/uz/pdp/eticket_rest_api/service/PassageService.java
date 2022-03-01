package uz.pdp.eticket_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_rest_api.repository.noSql.PassageRepository;

@Service
@RequiredArgsConstructor
public class PassageService {
    private final PassageRepository passageRepository;


}
