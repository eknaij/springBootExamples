package com.eknaij.springbootrabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootrabbitmqApplicationTests {

    @Test
    public void contextLoads() {

    }
    @Autowired
    private Sender helloSender;
    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

}
