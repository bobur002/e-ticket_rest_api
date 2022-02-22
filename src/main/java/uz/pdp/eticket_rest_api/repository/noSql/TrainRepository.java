package uz.pdp.eticket_rest_api.repository.noSql;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.eticket_model.model.noSQL.Train;

public interface TrainRepository extends MongoRepository<Train,String> {

}
