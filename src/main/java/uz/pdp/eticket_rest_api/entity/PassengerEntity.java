package uz.pdp.eticket_rest_api.entity;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.eticket_model.model.sql.Passenger;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class PassengerEntity extends Passenger {
    @ManyToOne
    UserEntity user;


}
