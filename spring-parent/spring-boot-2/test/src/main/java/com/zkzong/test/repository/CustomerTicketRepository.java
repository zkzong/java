package com.zkzong.test.repository;

import com.zkzong.test.domain.CustomerTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, Long> {

    List<CustomerTicket> getCustomerTicketByOrderNumber(String orderNumber);

}