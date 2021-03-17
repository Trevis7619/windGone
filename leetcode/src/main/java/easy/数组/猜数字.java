package easy.数组;

public class 猜数字 {

    public int game(int[] guess, int[] answer) {
        int result = 0;

        if(guess[0]-answer[0]==0){
            result=result+1;
        }
        if(guess[1]-answer[1]==0){
            result=result+1;
        }
        if(guess[2]-answer[2]==0){
            result=result+1;
        }
        return  result;
    }
}
