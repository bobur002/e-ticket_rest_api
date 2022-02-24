package uz.pdp.eticket_rest_api.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticket_model.model.sql.User;
import uz.pdp.eticket_rest_api.entity.UserEntity;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<User> findByEmail(String email);
}
