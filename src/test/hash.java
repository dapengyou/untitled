package test;

public class hash {
    public int hash(String key) {
        //获取后两位字符
        String lastTwoChars = key.substring(key.length() - 2, key.length());
        //将后两位字符转换为整数
        int hashValue = Integer.parseInt(lastTwoChars);
        return hashValue;
    }
}
