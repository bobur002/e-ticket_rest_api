package uz.pdp.eticket_rest_api.repository.noSql;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.eticket_model.model.noSQL.Passage;

public interface PassageRepository extends MongoRepository<Passage,String> {

}
