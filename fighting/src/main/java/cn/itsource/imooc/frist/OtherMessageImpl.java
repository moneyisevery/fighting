package cn.itsource.imooc.frist;

import org.springframework.stereotype.Component;

/**
 * @author yb
 * @date 2020/10/24 0024 13:37
 * @Description: 扩展  不该变原有类的逻辑
 * @Version:1.0
 */
@Component("myMessageImpl")
public class OtherMessageImpl implements MessageHolder {
    @Override
    public void sendWay() {
        System.out.println("kkkkkkkk");
    }
}
