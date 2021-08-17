package designMode.observe;

/**
 * @author lady_zhou
 * @date 创建时间: 2021/8/17
 * @Description 用户观察者
 */
public class UserObserver implements Observer {
    private String mUserName;

    public UserObserver(String userName) {
        this.mUserName = userName;
    }

    @Override
    public void update(Object message) {
        System.out.println(mUserName + " 收到了 " + message + "消息");
    }
}
