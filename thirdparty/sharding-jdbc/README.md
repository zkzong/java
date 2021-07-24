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


# 4 
## 分表
### inline方式
### 自定义算法
标准分片策略
对应StandardShardingStrategy。提供对SQL语句中的=, >, <, >=, <=, IN和BETWEEN AND的分片操作支持。StandardShardingStrategy只支持单分片键，提供PreciseShardingAlgorithm和RangeShardingAlgorithm两个分片算法。PreciseShardingAlgorithm是必选的，用于处理=和IN的分片。RangeShardingAlgorithm是可选的，用于处理BETWEEN AND, >, <, >=, <=分片，如果不配置RangeShardingAlgorithm，SQL中的BETWEEN AND将按照全库路由处理。

分页

大于小于有问题

# 5
## 分表
### inline方式
### 自定义算法

分页

大于小于


### todo

[ ] 雪花算法
自定义算法使用大于小于

