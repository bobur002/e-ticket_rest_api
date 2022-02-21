package uz.pdp.eticket_rest_api.entity;

import uz.pdp.eticket_model.model.postgresql.Passenger;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PassengerEntity extends Passenger {

    @ManyToOne
    UserEntity user;


}
