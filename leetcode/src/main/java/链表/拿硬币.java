package 链表;

public class 拿硬币 {

    public int minCount(int[] coins) {

        int sum = 0;
        for(int temp: coins){
            if(temp%2==1){
                sum=sum+(temp/2)+1;
            }else {
                sum=sum+(temp/2);
            }
        }
        return  sum;
    }
}
