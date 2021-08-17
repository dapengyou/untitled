package designMode.observe;

/**
 * @date 创建时间: 2021/8/17
 * @author  lady_zhou
 * @Description  观察者
 */
public interface Observer {
    //被观察者改变，观察者知道
    void update(Object message);
}
