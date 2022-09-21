package org.example.test.controller;

import org.example.test.domain.CustomerTicket;
import org.example.test.service.CustomerTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    private CustomerTicketService customerTicketService;

    @PostMapping(value = "/{accountId}/{orderNumber}")
    public CustomerTicket generateCustomerTicket(@PathVariable("accountId") Long accountId,
                                                 @PathVariable("orderNumber") String orderNumber) {

        CustomerTicket customerTicket = customerTicketService.generateCustomerTicket(accountId, orderNumber);

        return customerTicket;
    }

    @GetMapping(value = "/{id}")
    public CustomerTicket getCustomerTicketById(@PathVariable Long id) {

//		CustomerTicket customerTicket = customerTicketService.getCustomerTicketById(id);

        CustomerTicket customerTicket = new CustomerTicket();
        customerTicket.setId(1L);
        customerTicket.setAccountId(100L);
        customerTicket.setOrderNumber("Order00001");
        customerTicket.setDescription("DemoOrder");
        customerTicket.setCreateTime(new Date());

        return customerTicket;
    }

    @GetMapping(value = "/{pageIndex}/{pageSize}")
    public List<CustomerTicket> getCustomerTicketList(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        List<CustomerTicket> customerTickets = customerTicketService.getCustomerTickets(pageIndex, pageSize);

        return customerTickets;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomerTicket(@PathVariable("id") Long id) {

        customerTicketService.deleteCustomerTicket(id);
    }
}
