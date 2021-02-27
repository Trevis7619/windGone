package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *@author chenyijie
 *@Date  2021/2/26 11:15 下午
 */
public class 简单密码 {
    public static void main(String[] args) throws IOException {

        Map<Character,Integer> mapping = new HashMap<>();
        mapping.put('a',2);
        mapping.put('b',2);
        mapping.put('c',2);
        mapping.put('d',3);
        mapping.put('e',3);
        mapping.put('f',3);
        mapping.put('g',4);
        mapping.put('h',4);
        mapping.put('i',4);
        mapping.put('j',5);
        mapping.put('k',5);
        mapping.put('l',5);
        mapping.put('m',6);
        mapping.put('n',6);
        mapping.put('o',6);
        mapping.put('p',7);
        mapping.put('q',7);
        mapping.put('r',7);
        mapping.put('s',7);
        mapping.put('t',8);
        mapping.put('u',8);
        mapping.put('v',8);
        mapping.put('w',9);
        mapping.put('x',9);
        mapping.put('y',9);
        mapping.put('z',9);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] in = br.readLine().toCharArray();

        StringBuilder rs = new StringBuilder();

        for(char c: in){

          if(c=='Z'){
              rs.append("a");
          }

          if(c>='A' && c<'Z'){
              rs.append((char)(c+33));
          }
          if(c>='a' && c<='z'){
              rs.append(mapping.get(c));
          }else {
              rs.append(c);
          }

        }

        System.out.println(rs.toString());
    }
}
