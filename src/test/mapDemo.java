package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class mapDemo {

    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();

        m.put("zhangsan", 19);
        m.put("lisi", 49);
        m.put("wangwu", 19);
        m.put("lisi", 20);
        m.put("hanmeimei", null);
        System.out.println(m);

        //移除指定
        System.out.println(m.remove("wangwu"));

//        m.clear();
        System.out.println(m);

        //是否包含value为20
        System.out.println(m.containsValue(20));

        //是否包含key为张三
        System.out.println(m.containsKey("zhangsan"));

        //有映射关系返回false  没有映射关系返回true
        System.out.println(m.isEmpty());

        //返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null,否则返回相应的value
        System.out.println("指定键所映射的值:" + m.get("lisi"));

        //返回此映射中的键-值映射关系数。
        System.out.println("键-值映射关系数：" + m.size());

        //返回此映射中包含的值的集合 collection 视图
        System.out.println(m.values());

        // 返回此映射中包含的映射关系的 set 视图。
        System.out.println(m.entrySet());

        //返回此映射中包含的映射关系的 key 视图
        System.out.println(m.keySet());

        String osName = System.getProperty("os.name");
        String osVer = System.getProperty("os.version");
        String dir = System.getProperty("user.dir");
        String home = System.getProperty("user.home");
        System.out.println(osName + " v" + osVer + "----" + dir + "----" + home);


    }
}
