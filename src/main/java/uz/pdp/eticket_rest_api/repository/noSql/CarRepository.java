package uz.pdp.eticket_rest_api.repository.noSql;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.eticket_model.model.noSQL.Car;

import java.util.Optional;

public interface CarRepository extends MongoRepository<Car,String> {
    Optional<Car> findByCarType(String carType);
}
