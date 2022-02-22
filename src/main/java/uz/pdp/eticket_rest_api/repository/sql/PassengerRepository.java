package uz.pdp.eticket_rest_api.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticket_model.model.sql.Passenger;
import uz.pdp.eticket_rest_api.entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
}
