package easy;

public class 跳台阶拓展 {


    public  int jumpFloorII(int target) {

       if(target<=2){
           return  target;
       }

       return 2*jumpFloorII(target-1);
    }


}
