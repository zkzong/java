如果不使用雪花算法，则需要在程序中给orderId赋值，
```java
for (int i = 1; i <= 10; i++) {
    Order order = new Order();
    order.setOrderId(i);
    order.setUserId(i);
    order.setAddressId(i);
    order.setStatus("INSERT_TEST");
    orderMapper.insert(order);
    OrderItem item = new OrderItem();
    item.setOrderItemId(i);
    item.setOrderId(order.getOrderId());
    item.setUserId(i);
    item.setStatus("INSERT_TEST");
    orderItemMapper.insert(item);
    result.add(order.getOrderId());
}
```
并修改mapper的insert方法
```
<insert id="insert" useGeneratedKeys="true" keyProperty="orderId">
    INSERT INTO t_order (user_id, address_id, status) VALUES (#{userId,jdbcType=INTEGER}, #{addressId,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR});
</insert>
```
为
```
<insert id="insert" useGeneratedKeys="true" keyProperty="orderId">
    INSERT INTO t_order (order_id, user_id, address_id, status) VALUES (#{orderId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, #{addressId,jdbcType=BIGINT}, #{status,jdbcType=VARCHAR});
</insert>
```


`Inline sharding algorithm expression cannot be null`
spring boot 版本问题



### done

分表：inline方式、自定义算法（PreciseShardingAlgorithm不支持范围查询）
分页

### todo

[ ] 雪花算法

