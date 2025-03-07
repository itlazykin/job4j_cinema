package ru.job4j.cinema.service.ticket;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.repository.ticket.TicketRepository;

import java.util.Optional;

@Service
@ThreadSafe
public class SimpleTicketService implements TicketService {
    private final TicketRepository ticketRepository;

    public SimpleTicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Optional<Ticket> buyTicket(Ticket ticket) {
        return ticketRepository.buyTicket(ticket);
    }
}
