package uz.pdp.eticket_rest_api.repository.noSql;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.eticket_model.model.noSQL.Train;

import java.util.Optional;

public interface TrainRepository extends MongoRepository<Train,String> {
        Optional<Train> findByTrainName(String trainName);
}
