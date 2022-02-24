package uz.pdp.eticket_rest_api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.pdp.eticket_model.dto.receive.TicketReceiveDto;
import uz.pdp.eticket_rest_api.entity.TicketEntity;

@Component
public class TicketMapper {
    private final ModelMapper mapper;

    public TicketMapper() {
        this.mapper = new ModelMapper();
    }

    public TicketEntity ticketCreate(TicketReceiveDto ticketReceiveDto){
        return mapper.map(ticketReceiveDto,TicketEntity.class);
    }
}
