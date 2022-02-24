package uz.pdp.eticket_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_model.dto.receive.UserReceiveDto;
import uz.pdp.eticket_model.dto.responce.ApiResponse;
import uz.pdp.eticket_model.dto.responce.BaseResponse;
import uz.pdp.eticket_model.model.sql.User;
import uz.pdp.eticket_rest_api.entity.UserEntity;
import uz.pdp.eticket_rest_api.mapper.UserMapper;
import uz.pdp.eticket_rest_api.repository.sql.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public ApiResponse add(UserReceiveDto userReceiveDto) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<User> byEmail = userRepository.findByEmail(userReceiveDto.getEmail());
        if (byEmail.isPresent()) {
            apiResponse = BaseResponse.ALREADY_EXIST;
        }
        UserEntity user = mapper.userCreate(userReceiveDto);
        userRepository.save(user);
        return apiResponse;
    }

    public ApiResponse getUser(Long userId) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<UserEntity> byId = userRepository.findById(userId);
        if (byId.isEmpty()) {
            apiResponse = BaseResponse.NOT_FOUND;
        }
        apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(byId);
        return apiResponse;
    }

    public ApiResponse getUsers() {
        List<UserEntity> all = userRepository.findAll();
        ApiResponse apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(all);
        return apiResponse;
    }

    public ApiResponse delete(Long id) {
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            apiResponse = BaseResponse.NOT_FOUND;
        } else {
            userRepository.deleteById(id);
        }
        return apiResponse;
    }

}