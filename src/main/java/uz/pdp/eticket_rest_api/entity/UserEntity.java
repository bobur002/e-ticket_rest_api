package uz.pdp.eticket_rest_api.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticket_model.model.sql.Passenger;
import uz.pdp.eticket_model.model.sql.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserEntity extends User {
//    @OneToOne
//    private PassengerEntity passenger;

}
