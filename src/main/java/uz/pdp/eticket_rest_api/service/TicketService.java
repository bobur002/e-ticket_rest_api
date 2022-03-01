package uz.pdp.eticket_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_model.dto.receive.TicketReceiveDto;
import uz.pdp.eticket_model.dto.responce.ApiResponse;
import uz.pdp.eticket_model.dto.responce.BaseResponse;
import uz.pdp.eticket_rest_api.entity.PassengerEntity;
import uz.pdp.eticket_rest_api.entity.TicketEntity;
import uz.pdp.eticket_rest_api.entity.UserEntity;
import uz.pdp.eticket_rest_api.mapper.TicketMapper;
import uz.pdp.eticket_rest_api.repository.sql.PassengerRepository;
import uz.pdp.eticket_rest_api.repository.sql.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper mapper;
    private final PassengerRepository passengerRepository;

    public ApiResponse add(TicketReceiveDto ticketReceiveDto) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<PassengerEntity> byId = passengerRepository.findById(ticketReceiveDto.getPassengerId());
        if (byId.isEmpty()) {
            apiResponse = BaseResponse.NOT_FOUND;
        }
        TicketEntity ticketEntity = mapper.ticketCreate(ticketReceiveDto);
        ticketEntity.setPassenger(byId.get());
        ticketRepository.save(ticketEntity);
        return apiResponse;
    }

    public ApiResponse getTicket(Long ticketId) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<TicketEntity> byId = ticketRepository.findById(ticketId);
        if (byId.isEmpty()) {
            apiResponse = BaseResponse.NOT_FOUND;
        }
        apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(byId);
        return apiResponse;
    }

    public ApiResponse getTickets() {
        List<TicketEntity> all = ticketRepository.findAll();
        ApiResponse apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(all);
        return apiResponse;
    }

    public ApiResponse delete(Long id) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<TicketEntity> byId = ticketRepository.findById(id);
        if (byId.isEmpty()) {
            apiResponse = BaseResponse.NOT_FOUND;
        } else {
            ticketRepository.deleteById(id);
        }
        return apiResponse;
    }

}
