package uz.pdp.eticket_rest_api.entity;

import uz.pdp.eticket_model.model.sql.Ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TicketEntity extends Ticket {

    @OneToOne
    PassengerEntity passenger;

    @OneToOne
    PassengerEntity childPassenger;
}
