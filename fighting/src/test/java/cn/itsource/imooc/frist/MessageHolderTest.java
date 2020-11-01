package cn.itsource.imooc.frist;


import cn.itsource.imooc.frist.config.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageHolderTest {

    @Autowired
    private MessageHolder myMessageImpl;
    @Test
    public void createDeployment() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);
        Object myMessageImpl = context.getBean("myMessageImpl");
        System.out.println(myMessageImpl);
        this.myMessageImpl.sendWay();
    }

}
