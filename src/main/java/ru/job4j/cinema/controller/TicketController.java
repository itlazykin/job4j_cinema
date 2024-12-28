package ru.job4j.cinema.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.service.ticket.TicketService;

@Controller
@RequestMapping("/tickets")
@ThreadSafe
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/buy")
    public String buyTicket(@ModelAttribute Ticket ticket, Model model) {
        var result = ticketService.buyTicket(ticket);
        if (result.isEmpty()) {
            model.addAttribute("message", "Не удалось купить билет. "
                    + "Выбранное Вами место - занято.");
            return "tickets/failure";
        }
        model.addAttribute("message",
                String.format("Билет приобретен на : ряд, место с номерами: %d, %d",
                        ticket.getRowNumber(),
                        ticket.getPlaceNumber()
                )
        );
        return "tickets/success";
    }
}