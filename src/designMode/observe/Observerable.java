package designMode.observe;

/**
 * @author lady_zhou
 * @date 创建时间: 2021/8/17
 * @Description 被观察者
 */
public interface Observerable {
    //添加观察者
    void addObserve(Observer observer);

    //删除观察者
    void deleteObserve(Observer observer);

    //被观察者改变
    void notifyObservers();

    //被观察者发布消息
    void pushMessage(String message);
}
