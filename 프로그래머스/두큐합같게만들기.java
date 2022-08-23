package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    public static void main(String[] args) {
        int[] queue1 = {};
        int[] queue2 = {};

        solution(queue1, queue2);

    }

    public static int solution(int[] queue1, int[] queue2) {

        long sumQueue1 = 0, sumQueue2 = 0;
        long halfNum = 0;
        Queue<Integer> realQueue1 = new LinkedList<>();
        Queue<Integer> realQueue2 = new LinkedList<>();

        int count = 0;

        for(int a : queue1){
            sumQueue1 += a;
            realQueue1.add(a);
        }
        for(int b : queue2){
            sumQueue2 += b;
            realQueue2.add(b);
        }

        halfNum = (sumQueue1 + sumQueue2) / 2;

        if((sumQueue1 + sumQueue2) % 2 != 0){
            return -1;
        }

        int length = queue1.length;

        while(true){
            if(count > (length+length)*2) {
                return -1;
            }
            if(sumQueue1 > sumQueue2){
                int pop = realQueue1.poll();

                if(pop == sumQueue1 && pop > halfNum){
                    return -1;
                }

                realQueue2.add(pop);

                sumQueue1 -= pop;
                sumQueue2 += pop;

                count++;

            }else if (sumQueue2 > sumQueue1){

                int pop = realQueue2.poll();

                if(pop == sumQueue2 && pop > halfNum){
                    return -1;
                }

                realQueue1.add(pop);

                sumQueue1 += pop;
                sumQueue2 -= pop;

                count++;
            }else{
                break;
            }
        }
        return count;
    }

}
