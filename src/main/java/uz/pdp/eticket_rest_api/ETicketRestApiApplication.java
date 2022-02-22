package uz.pdp.eticket_rest_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.pdp.eticket_model.model.noSQL.Car;
import uz.pdp.eticket_model.model.noSQL.Seat;
import uz.pdp.eticket_rest_api.repository.noSql.CarRepository;

import java.util.List;

@SpringBootApplication

public class ETicketRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETicketRestApiApplication.class, args);
    }


}
