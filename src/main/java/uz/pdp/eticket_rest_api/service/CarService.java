package uz.pdp.eticket_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_model.dto.receive.CarReceiveDTO;
import uz.pdp.eticket_model.dto.responce.ApiResponse;
import uz.pdp.eticket_model.dto.responce.BaseResponse;
import uz.pdp.eticket_model.model.noSQL.Car;
import uz.pdp.eticket_model.model.noSQL.Seat;
import uz.pdp.eticket_rest_api.repository.noSql.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public ApiResponse addCar(CarReceiveDTO carReceiveDTO){
        ApiResponse apiResponse = BaseResponse.SUCCESS;
        Car car = new Car(carReceiveDTO.getCarType(),carReceiveDTO.getPrice(),new ArrayList<>());
        for (int i = 1; i <= carReceiveDTO.getSeatCount(); i++) {
           Seat seat = new Seat();
           seat.setSeatNumber(String.valueOf(i));
           car.getSeats().add(seat);
        }
        Optional<Car> byCarType = carRepository.findByCarType(car.getCarType());

        if (byCarType.isPresent()) {
            apiResponse = BaseResponse.ERROR_CAR_ALREADY_EXIST;
        }else {
            carRepository.insert(car);
        }

        return apiResponse;
    }

    public ApiResponse getCarTypes(){
        List<String> carTypes = new ArrayList<>();

        for (Car car : carRepository.findAll()) {
            carTypes.add(car.getCarType());
        }
        ApiResponse apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(carTypes);

        return apiResponse;
    }

    public ApiResponse getCarList() {
        List<Car> all = carRepository.findAll();
        ApiResponse apiResponse = BaseResponse.SUCCESS_WITH_DATA;
        apiResponse.setData(all);
        return apiResponse;
    }
}
