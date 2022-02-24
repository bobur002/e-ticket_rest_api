package uz.pdp.eticket_rest_api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.pdp.eticket_model.dto.receive.PassengerReceiveDto;
import uz.pdp.eticket_model.dto.receive.TicketReceiveDto;
import uz.pdp.eticket_rest_api.entity.PassengerEntity;
import uz.pdp.eticket_rest_api.entity.TicketEntity;

@Component
public class PassengerMapper {
    private final ModelMapper mapper;

    public PassengerMapper() {
        this.mapper = new ModelMapper();
    }
    public PassengerEntity passengerCreate(PassengerReceiveDto passengerReceiveDto){
        return mapper.map(passengerReceiveDto,PassengerEntity.class);
    }

}
