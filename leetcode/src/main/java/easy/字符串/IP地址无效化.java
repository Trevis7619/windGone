package easy.字符串;


/**
 *@author chenyijie
 *@Date  2021/3/14 8:23 下午
 *
 * 优化: 用String的 replace函数
 */
public class IP地址无效化 {

    public String defangIPaddr(String address) {


        String[] temp = address.split("\\.");

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<temp.length-1;i++){
            stringBuilder.append(temp[i]);
            stringBuilder.append("[.]");
        }
        stringBuilder.append(temp[temp.length-1]);
        return stringBuilder.toString();
    }

}
