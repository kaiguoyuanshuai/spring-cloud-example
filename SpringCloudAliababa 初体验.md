## 技术栈
- SpringCloud 
- SpringBoot 
- SpringCloudAlibaba
- Dubbo
- Sentinel 
- Nacos 
- Dubbo Ops 
- Druid
- Mybatis
## 最终效果 

## 初体验

## 集成

### 集成 `Druid` 和 `Mybaits` 

#### 集成 `Druid` 
> https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter

##### 引入Maven配置
```xml
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.10</version>
    </dependency>
```

##### 添加配置
```properties
spring.datasource.url= 
spring.datasource.username=
spring.datasource.password=
```

##### 连接池配置 
```properties
spring.datasource.druid.initial-size=
spring.datasource.druid.max-active=
spring.datasource.druid.min-idle=
spring.datasource.druid.max-wait=
spring.datasource.druid.pool-prepared-statements=
spring.datasource.druid.max-pool-prepared-statement-per-connection-size= 
spring.datasource.druid.max-open-prepared-statements= #和上面的等价
spring.datasource.druid.validation-query=
spring.datasource.druid.validation-query-timeout=
spring.datasource.druid.test-on-borrow=
spring.datasource.druid.test-on-return=
spring.datasource.druid.test-while-idle=
spring.datasource.druid.time-between-eviction-runs-millis=
spring.datasource.druid.min-evictable-idle-time-millis=
spring.datasource.druid.max-evictable-idle-time-millis=
spring.datasource.druid.filters= #配置多个英文逗号分隔
```

##### 监控配置


##### 多数据源
> https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter#%E5%A6%82%E4%BD%95%E9%85%8D%E7%BD%AE%E5%A4%9A%E6%95%B0%E6%8D%AE%E6%BA%90




#### 集成 `Mybaits` 

##### 引入Maven配置
```xml
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.1</version>
        </dependency>
```

##### 添加配置

```properties
#=======================DB======================
spring.datasource.url=jdbc:mysql://localhost:3306/spring_cloud?serverTimezone=UTC&characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=asdf1234

#========================Mybatis====================
mybatis.mapper-locations=classpath*:mappers/*.mapper.xml
mybatis.type-aliases-package=com.zcoco.springcloud.alibaba.repertory.mapper.vo

```
注意:
- 这里使用的`mysql-connector-java` 版本为`8.*` 所以需要在末尾最佳 `serverTimezone=UTC`
- mybatis 采用xml 配置，所以 需要配置 `mybatis.mapper-locations=classpath*:mappers/*.mapper.xml`
- 自动映射VO `mybatis.type-aliases-package=com.zcoco.springcloud.alibaba.repertory.mapper.vo`


##### 添加日志
```properties
logging.level.com.zcoco.springcloud.alibaba.repertory.mapper=debug
```
日志打印配置




### 集成 `seata`

> https://github.com/spring-cloud-incubator/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-examples/seata-example/readme-zh.md
> https://github.com/seata/seata-samples/tree/master/nacos

```xml
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-seata</artifactId>
</dependency>
```

下载 seata (注意版本 )
```
unzip XXXXseata.zip 
```
修改配置 
file.conf
```
service {
  #vgroup->rgroup
  #my_test_tx_group 需要与 GlobalTransactionScanner 第二个参数一致
  vgroup_mapping.my_test_tx_group = "default"
  #only support single node
  #配置成远程服务器的地址
  default.grouplist = "47.98.131.177:8091"
  #degrade current not support
  enableDegrade = false
  #disable
  disable = false
}

```
registry.conf
```
registry {
  # file nacos
  type = "nacos"
  nacos {
    serverAddr = "47.98.131.177"
    namespace = "public"
    cluster = "default"
  }
  file {
    name = "file.conf"
  }
}
config {
    type = "nacos"
    nacos {
        serverAddr = "47.98.131.177"
        namespace = "public"
        cluster = "default"
    }
}
```
执行 nacos-config.sh
```
sh nacos-config.sh localhost
```

启动 seata

```
sh seata-server.sh 8091 file 47.98.131.177 
```
- 最后一个IP地址需要制定，不然会使用服务器内网IP 导致本地无法访问的问题

