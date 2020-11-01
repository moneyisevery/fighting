package cn.itsource.imooc.frist.config;

import cn.itsource.imooc.frist.MyMessageImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yb
 * @date 2020/10/24 0024 13:28
 * @Description:
 * @Version:1.0
 */
@Configuration
public class MyConfig {
    /**
     *  ConditionalOnMissingBean 如果name为“myMessageImpl”的bean存在，这该注解修饰的代码块不执行。
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "myMessageImpl")
    public MyMessageImpl myMessageImpl(){
      return new MyMessageImpl();
    }
}
