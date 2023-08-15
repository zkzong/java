
package com.example.sj4.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.sj4.entity.Order;
import com.example.sj4.entity.OrderItem;
import com.example.sj4.repository.OrderItemMapper;
import com.example.sj4.repository.OrderMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class OrderServiceImpl implements ExampleService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    //@Resource
    //private AddressRepository addressRepository;

    @Override
    public void initEnvironment() throws SQLException {
        orderMapper.createTableIfNotExists();
        orderItemMapper.createTableIfNotExists();
        orderMapper.truncateTable();
        orderItemMapper.truncateTable();
        //initAddressTable();
    }

    //private void initAddressTable() throws SQLException {
    //    addressRepository.createTableIfNotExists();
    //    addressRepository.truncateTable();
    //    for (int i = 1; i <= 10; i++) {
    //        Address entity = new Address();
    //        entity.setAddressId((long) i);
    //        entity.setAddressName("address_" + String.valueOf(i));
    //        addressRepository.insert(entity);
    //    }
    //}

    @Override
    public void cleanEnvironment() throws SQLException {
        orderMapper.dropTable();
        orderItemMapper.dropTable();
    }

    @Override
    @Transactional
    public void processSuccess() throws SQLException {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> orderIds = insertData();
        printData();
        //deleteData(orderIds);
        printData();
        System.out.println("-------------- Process Success Finish --------------");
    }

    @Override
    @Transactional
    public void processFailure() throws SQLException {
        System.out.println("-------------- Process Failure Begin ---------------");
        insertData();
        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }

    private List<Long> insertData() throws SQLException {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setOrderId(Long.valueOf(i));
            order.setUserId(i);
            order.setAddressId(Long.valueOf(i));
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            OrderItem item = new OrderItem();
            item.setOrderItemId(Long.valueOf(i));
            item.setOrderId(order.getOrderId());
            item.setUserId(i);
            item.setStatus("INSERT_TEST");
            orderItemMapper.insert(item);
            result.add(order.getOrderId());
        }
        return result;
    }

    private void deleteData(final List<Long> orderIds) throws SQLException {
        System.out.println("---------------------------- Delete Data ----------------------------");
        for (Long each : orderIds) {
            orderMapper.delete(each);
            orderItemMapper.delete(each);
        }
    }

    @Override
    public void printData() throws SQLException {
        System.out.println("---------------------------- Print Order Data -----------------------");
        for (Object each : orderMapper.selectAll()) {
            System.out.println(each);
        }
        System.out.println("---------------------------- Print OrderItem Data -------------------");
        for (Object each : orderItemMapper.selectAll()) {
            System.out.println(each);
        }
    }

    @Override
    public Order selectByOrderId() {
        return orderMapper.selectByOrderId();
    }

    @Override
    public List<Order> selectRange() {
        List<Order> orders = orderMapper.selectRange();
        return orders;
    }

    @Override
    public List<Order> selectgt() {
        List<Order> orders = orderMapper.selectgt();
        return orders;
    }

    @Override
    public List<Order> selectlt() {
        List<Order> orders = orderMapper.selectlt();
        return orders;
    }

    @Override
    public PageInfo<Order> page() {
        PageHelper.startPage(1, 1);
        List<Order> orders = orderMapper.selectAll();
        PageInfo<Order> page = new PageInfo<>(orders);
        return page;
    }
}
