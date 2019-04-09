package cinema.services;

import cinema.configuration.RepositoryConfig;
import cinema.domain.repository.TicketRepository;

public class TicketService {
    TicketRepository ticketRepository = RepositoryConfig.getInstance().getTicketRepository();


}
