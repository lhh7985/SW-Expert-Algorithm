import java.util.PriorityQueue;
import java.util.Scanner;

public class 가운데를말해요 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> upper = new PriorityQueue<>((o1, o2) -> o1-o2);
        PriorityQueue<Integer> under = new PriorityQueue<>((o1, o2) -> o2-o1);

        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            if(upper.size() == under.size()) under.offer(num);
            else upper.offer(num);

            if(!upper.isEmpty() && !under.isEmpty()){
                if(upper.peek() < under.peek()){
                    int top = upper.poll();
                    upper.offer(under.poll());
                    under.offer(top);
                }
            }
            sb.append(under.peek()+"\n");
        }
        System.out.println(sb);
    }
}