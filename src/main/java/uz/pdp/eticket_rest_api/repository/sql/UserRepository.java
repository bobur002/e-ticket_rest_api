package uz.pdp.eticket_rest_api.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticket_rest_api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
