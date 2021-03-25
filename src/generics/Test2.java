package generics;

/**
 * @author lady_zhou
 * @Description 泛型类可以有多个类型参数
 */
public class Test2 {

    public interface Pair<K, V> {
        K getKey();

        V getValue();
    }

    public static class OrderedPair<K, V> implements Pair<K, V> {
        private K key;
        private V value;

        public OrderedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }


    public static void main(String[] args) {
        OrderedPair orderedPair = new OrderedPair<>("hello", 1);
        System.out.println(orderedPair.getKey() + "\t\t" + orderedPair.getValue());
    }
}


