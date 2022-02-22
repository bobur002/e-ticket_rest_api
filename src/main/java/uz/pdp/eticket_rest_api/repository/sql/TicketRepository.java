package uz.pdp.eticket_rest_api.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eticket_rest_api.entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
