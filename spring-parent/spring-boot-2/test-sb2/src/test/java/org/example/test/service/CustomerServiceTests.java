package org.example.test.service;

import org.example.test.domain.CustomerTicket;
import org.example.test.repository.CustomerTicketRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CustomerServiceTests {

    @MockBean
    private CustomerTicketRepository customerTicketRepository;

    @Autowired
    private CustomerTicketService customerTicketService;

    @Test
    public void testGetCustomerTicketById() throws Exception {
        Long id = 1L;

        Mockito.when(customerTicketRepository.getOne(id)).thenReturn(new CustomerTicket(1L, 1L, "Order00001", "DemoCustomerTicket1", new Date()));

        CustomerTicket actual = customerTicketService.getCustomerTicketById(id);

        assertThat(actual).isNotNull();
        assertThat(actual.getOrderNumber()).isEqualTo("Order00001");
    }

    @Test
    public void testGenerateCustomerTicket() throws Exception {
        Long accountId = 100L;
        String orderNumber = "Order00001";

        CustomerTicket actual = customerTicketService.generateCustomerTicket(accountId, orderNumber);

        assertThat(actual.getOrderNumber()).isEqualTo(orderNumber);
    }
}