package org.client.com.server;

import org.client.com.Application;
import org.client.com.util.resultJson.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AccountInterfaceTest {

    private final static Logger logger = LoggerFactory.getLogger(AccountInterfaceTest.class);

    @Autowired
    private AccountInterface anInterface;

    @Test
    public void test() {
        try {
            ResponseResult result = anInterface.getById("测试");
            System.out.println(result.toString());
        } catch (Exception e) {
            System.out.println("接口断开");
        }
    }
}