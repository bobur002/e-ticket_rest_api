package uz.pdp.eticket_rest_api.entity;

import uz.pdp.eticket_model.model.postgresql.Ticket;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class TicketEntity extends Ticket {

    @OneToOne
    PassengerEntity passenger;

    @OneToOne
    @Column(name = "child_passenger")
    PassengerEntity childPassenger;
}
