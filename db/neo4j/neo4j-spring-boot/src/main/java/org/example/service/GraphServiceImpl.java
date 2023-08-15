package com.example.service;

import com.example.entity.CustomerNode;
import com.example.entity.CustomerRelation;
import com.example.repository.CustomerNodeRepository;
import com.example.repository.CustomerRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphServiceImpl implements GraphService {
    @Autowired
    private CustomerRelationRepository customerRelationRepository;
    @Autowired
    private CustomerNodeRepository customerRepository;

    @Override
    public void deleteNodeById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteNodeByName(String name) {
        customerRepository.deleteByName(name);
    }

    @Override
    public void delete() {
        customerRepository.deleteAll();
    }

    @Override
    public void addNode(String name, Integer age, String nameTo, String remark) {
        CustomerNode customerNode = new CustomerNode();
        customerNode.setName(name);
        customerNode.setAge(age);
        customerRepository.save(customerNode);

        CustomerNode customerNodeTo = customerRepository.findByName(nameTo);
        if (customerNodeTo != null) {
            CustomerRelation customerRelation = new CustomerRelation(customerNode, customerNodeTo, remark);
            customerRelationRepository.save(customerRelation);
        }
        //此处应该返回提示信息
    }

    /**
     * 根据ID修改节点的值
     *
     * @param id
     * @param name
     * @param age
     */
    @Override
    public void updateNode(Long id, String name, Integer age) {
        CustomerNode customerNode = customerRepository.findNodeById(id);
        customerNode.setName(name);
        customerNode.setAge(age);
        customerRepository.save(customerNode);
    }

    @Override
    public Iterable<CustomerNode> queryNodes() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerNode findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public List<CustomerNode> queryNodes(String name) {
        return customerRepository.findRelationByCustomerNode(name);
    }
}
