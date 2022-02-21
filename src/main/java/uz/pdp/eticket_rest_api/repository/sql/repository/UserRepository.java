package uz.pdp.eticket_rest_api.repository.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticket_model.model.postgresql.User;
import uz.pdp.eticket_rest_api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
