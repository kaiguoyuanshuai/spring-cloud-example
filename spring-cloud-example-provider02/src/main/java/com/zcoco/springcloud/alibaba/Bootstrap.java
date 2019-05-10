package com.zcoco.springcloud.alibaba;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.zcoco.springcloud")
public class Bootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Bootstrap.class).run(args);
    }
/*
    @RestController
    @Service
    class EchoController {

        @Autowired
        private TestConfig testConfig;


        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ResponseEntity index() {
            return new ResponseEntity("index error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @RequestMapping(value = "/test", method = RequestMethod.GET)
        public ResponseEntity test() {
            return new ResponseEntity("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @RequestMapping(value = "/sleep", method = RequestMethod.GET)
        public String sleep() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok";
        }

        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "hello Nacos Discovery " + string + " and port is " + testConfig.getPort() + ";" + testConfig.getName();
        }

        @RequestMapping(value = "/divide", method = RequestMethod.GET)
        public String divide(@RequestParam Integer a, @RequestParam Integer b) {
            return String.valueOf(a / b);
        }
    }*/
}
