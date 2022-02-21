package uz.pdp.eticket_rest_api.repository.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticket_model.model.postgresql.Passenger;
import uz.pdp.eticket_rest_api.entity.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
}
