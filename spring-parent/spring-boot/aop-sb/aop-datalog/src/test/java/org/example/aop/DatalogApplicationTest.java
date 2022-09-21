package org.example.aop;

import org.example.aop.dao.ProductDao;
import org.example.aop.datalog.ActionDao;
import org.example.aop.domain.Action;
import org.example.aop.domain.ActionType;
import org.example.aop.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatalogApplicationTest {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ActionDao actionDao;

    @Test
    public void testInsert() {
        Product product = new Product();
        product.setName("dell computer");
        product.setOnlineTime(new Date());
        product.setBuyPrice(new BigDecimal("29.5"));
        product.setCategory("computer");
        product.setDetail("this is a dell notebook");
        product.setUpdateTime(new Date());
        productDao.save(product);
        System.out.println("new product id:" + product.getId());
    }

    @Test
    public void testUpdate() {
        Product product = new Product();
        product.setId(1L);
        product.setName("宗");
        productDao.save(product);

        product = productDao.findOne(1L);
        product.setName("马");
        product.setBuyPrice(new BigDecimal("23.5"));
        product.setOnlineTime(new Date());
        productDao.save(product);
    }

    @Test
    public void testDelete() {
        productDao.delete(1L);
    }

    @Test
    public void testSaveMongo() {
        Action action = new Action();
        action.setId("1");
        action.setObjectId(1L);
        action.setObjectClass("mongo");
        action.setOperator("admin");
        action.setOperateTime(new Date());
        action.setActionType(ActionType.INSERT);
        //action.setChanges(Lists.newArrayList());

        actionDao.save(action);
    }

}