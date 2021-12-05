package com.zkzong.test.service;

import com.zkzong.test.domain.CustomerTicket;
import com.zkzong.test.repository.CustomerTicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerTicketService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerTicketService.class);

    @Autowired
    private CustomerTicketRepository customerTicketRepository;


    public CustomerTicket generateCustomerTicket(Long accountId, String orderNumber) {

        logger.debug("Generate customer ticket record with account: {} and order: {}", accountId, orderNumber);

        CustomerTicket customerTicket = new CustomerTicket();

        logger.debug("Get remote order: {} is successful", orderNumber);

        // 创建并保存CustomerTicket信息
        customerTicket.setAccountId(accountId);
        customerTicket.setCreateTime(new Date());
        customerTicket.setDescription("TestCustomerTicket");
        customerTicketRepository.save(customerTicket);

        return customerTicket;
    }

    public List<CustomerTicket> getCustomerTickets(int pageIndex, int pageSize) {
        return customerTicketRepository.findAll(PageRequest.of(pageIndex - 1, pageSize, Sort.DEFAULT_DIRECTION))
                .getContent();
    }

    public CustomerTicket getCustomerTicketById(Long id) {
        return customerTicketRepository.getOne(id);
    }

    public void deleteCustomerTicket(Long id) {
        customerTicketRepository.deleteById(id);
    }

}
