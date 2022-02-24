package uz.pdp.eticket_rest_api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.pdp.eticket_model.dto.receive.UserReceiveDto;
import uz.pdp.eticket_rest_api.entity.UserEntity;

@Component
public class UserMapper {
    private final ModelMapper mapper;

    public UserMapper() {
        this.mapper = new ModelMapper();
    }

    public UserEntity userCreate(UserReceiveDto userReceiveDto) {
        return mapper.map(userReceiveDto, UserEntity.class);
    }

}
