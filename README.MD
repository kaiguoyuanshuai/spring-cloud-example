## 启动流程

### 启动 Nacos
- run with windows
```
    cd %Nacos_Home%\bin 
    startup.cmd -m standalone 
```
- visit nacos console
```
http://10.26.201.122:8848/nacos
```
### 启动  `spring-cloud-example-consumer` 服务提供者

```
    java -jar spring-cloud-example-consumer.jar -Dserve.port=1010
```
    


### 启动  `spring-cloud-example-provider` 服务消费者

```
    java -jar  spring-cloud-example-provider.jar  -Dserve.port=1020
```

### 启动  sentinel
- run sentinel
```
java -Dserver.port=8888 -Dcsp.sentinel.dashboard.server=localhost:8888 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.5.1.jar
```
- visit sentinel 
```
http://localhost:8888/#/dashboard/home
```

### 启动 `dubbo ops` (暂未研究)
- run dubbo ops
```
java -Dserver.port=7777  -jar dubbo-admin-0.1.jar
```
- visit  dubbo ops 
```
    http://localhost:7777
```

### 安装 `RabbitMQ` (Window) 
- 安装 `erlang` 

    1.执行安装包
    2.设置 环境变量 
    ```
    %ERLANG_HOME%=D:\Program Files\erl10.3
    ```
    
- 安装 `RabbitMQ` 
    1. 执行安装包
    2.设置环境变量 
    ```
    %RABBITMQ_SERVER%=D:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.14
    ```
    3. Ingles


## 采坑指南

-  Spring-Cloud-Alibaba 本身不指定 Spring-Boot Spring-Cloud 版本 
```xml
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>0.2.1.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <!-- Import dependency management from Spring Boot -->
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.1.4.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <!-- Import dependency management from Spring Cloud -->
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
-  Spring Cloud 与 Spring Boot 版本不一致的错误 

[错误说明](https://github.com/spring-cloud-incubator/spring-cloud-alibaba/issues/105)


- 使用 `@FeignClient `需要手动引入 
```xml
  <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
```


-  集成 `Sentinel` 

集成 Sentinel 时 ，默认为懒加载 如果没有设置 `
spring.cloud.sentinel.eager=true` 或者访问埋点资源的URL 则无法在控制台找到   



- 集成 `dubbo` 
整合 Dubbo的时候 出现以下错造成无法启动的问题  
```
2019-04-26 16:36:56.485 ERROR 10584 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Field dubboMetadata in org.apache.dubbo.spring.boot.actuate.endpoint.DubboMetadataEndpoint required a bean of type 'org.apache.dubbo.spring.boot.actuate.endpoint.metadata.DubboMetadata' that could not be found.

The injection point has the following annotations:
	- @org.springframework.beans.factory.annotation.Autowired(required=true)


Action:

Consider defining a bean of type 'org.apache.dubbo.spring.boot.actuate.endpoint.metadata.DubboMetadata' in your configuration.

```

小马哥原话 : 
```
<!-- Spring Boot dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-actuator</artifactId>
    </dependency>
    这个是一个缺陷
```


- 集成 springcloudalibaba 无法使用 `@LoadBalanced`
```java
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
```
异常 : 
```

java.lang.NullPointerException: null
	at org.springframework.cloud.alibaba.dubbo.metadata.resolver.DubboTransportedAttributesResolver.resolve(DubboTransportedAttributesResolver.java:47) ~[spring-cloud-alibaba-dubbo-0.9.0.RELEASE.jar:0.9.0.RELEASE]
	at org.springframework.cloud.alibaba.dubbo.autoconfigure.DubboLoadBalancedRestTemplateAutoConfiguration.getDubboTranslatedAttributes(DubboLoadBalancedRestTemplateAutoConfiguration.java:143) ~[spring-cloud-alibaba-dubbo-0.9.0.RELEASE.jar:0.9.0.RELEASE]
	at org.springframework.cloud.alibaba.dubbo.autoconfigure.DubboLoadBalancedRestTemplateAutoConfiguration.adaptRestTemplates(DubboLoadBalancedRestTemplateAutoConfiguration.java:118) ~[spring-cloud-alibaba-dubbo-0.9.0.RELEASE.jar:0.9.0.RELEASE]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_121]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_121]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_121]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_121]
	at org.springframework.context.event.ApplicationListenerMethodAdapter.doInvoke(ApplicationListenerMethodAdapter.java:261) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.context.event.ApplicationListenerMethodAdapter.processEvent(ApplicationListenerMethodAdapter.java:179) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.context.event.ApplicationListenerMethodAdapter.onApplicationEvent(ApplicationListenerMethodAdapter.java:142) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:172) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:165) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:139) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:402) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:359) ~[spring-context-5.1.6.RELEASE.jar:5.1.6.RELEASE]
	at org.springframework.boot.context.event.EventPublishingRunListener.started(EventPublishingRunListener.java:99) ~[spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at org.springframework.boot.SpringApplicationRunListeners.started(SpringApplicationRunListeners.java:72) ~[spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:323) [spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) [spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) [spring-boot-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at com.zcoco.springcloud.alibaba.ConsumerBootstrap.main(ConsumerBootstrap.java:24) [classes/:na]
```
~~需要去掉 `@LoadBalanced`相关配置~~

需要添加 `@DubboTransported` :
```java
    @Bean
    @LoadBalanced
    @DubboTransported
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
```



