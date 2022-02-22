package uz.pdp.eticket_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticket_model.dto.receive.CarDTO;
import uz.pdp.eticket_model.dto.receive.TrainReceiveDTO;
import uz.pdp.eticket_model.dto.responce.ApiResponse;
import uz.pdp.eticket_model.dto.responce.BaseResponse;
import uz.pdp.eticket_model.model.noSQL.Car;
import uz.pdp.eticket_model.model.noSQL.Train;
import uz.pdp.eticket_rest_api.repository.noSql.CarRepository;
import uz.pdp.eticket_rest_api.repository.noSql.TrainRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainRepository trainRepository;

    private final CarRepository carRepository;

    public ApiResponse addTrain(TrainReceiveDTO trainReceiveDTO) {

        Optional<Train> byTrainName = trainRepository.findByTrainName(trainReceiveDTO.getTrainName());

        if (byTrainName.isPresent()) {
            return BaseResponse.ERROR_TRAIN_ALREADY_EXIST;
        }
        Train train = new Train(trainReceiveDTO.getTrainName(),new ArrayList<>(),trainReceiveDTO.getPriceByKM());

        for (CarDTO carDTO : trainReceiveDTO.getCars()) {
            Optional<Car> byCarType = carRepository.findByCarType(carDTO.getCarType());

            for (int i = 0; i < carDTO.getCount(); i++) {
                byCarType.ifPresent(car -> train.getCars().add(car));
            }
        }

        if (train.getCars().size()!=0) {
            trainRepository.insert(train);
        }else {
            return BaseResponse.ERROR_TRAIN_ALREADY_EXIST;
        }

        return BaseResponse.SUCCESS;
    }
}
