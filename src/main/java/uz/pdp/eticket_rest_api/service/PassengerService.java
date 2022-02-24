package uz.pdp.eticket_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_model.dto.receive.PassengerReceiveDto;
import uz.pdp.eticket_model.dto.receive.TicketReceiveDto;
import uz.pdp.eticket_model.dto.responce.ApiResponse;
import uz.pdp.eticket_model.dto.responce.BaseResponse;
import uz.pdp.eticket_rest_api.entity.PassengerEntity;
import uz.pdp.eticket_rest_api.entity.TicketEntity;
import uz.pdp.eticket_rest_api.mapper.PassengerMapper;
import uz.pdp.eticket_rest_api.mapper.TicketMapper;
import uz.pdp.eticket_rest_api.repository.sql.PassengerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;
    private final PassengerMapper mapper;

    public ApiResponse add(PassengerReceiveDto passengerReceiveDto) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        PassengerEntity passengerEntity = mapper.passengerCreate(passengerReceiveDto);
        passengerRepository.save(passengerEntity);
        return apiResponse;
    }

    public ApiResponse getpassenger(Long id) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<PassengerEntity> byId = passengerRepository.findById(id);
        if (byId.isEmpty()) {
            apiResponse = BaseResponse.NOT_FOUND;
        }
        apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(byId);
        return apiResponse;
    }

    public ApiResponse getPassengers() {
        List<PassengerEntity> all = passengerRepository.findAll();
        ApiResponse apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(all);
        return apiResponse;
    }

    public ApiResponse delete(Long id) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<PassengerEntity> byId = passengerRepository.findById(id);
        if (byId.isEmpty()) {
            apiResponse = BaseResponse.NOT_FOUND;
        } else {
            passengerRepository.deleteById(id);
        }
        return apiResponse;
    }


}
