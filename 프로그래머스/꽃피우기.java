package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 꽃피우기 {
    public static class node {
        int x = 0, y = 0;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.
        Queue<node> list = new LinkedList<>();

        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                if (garden[i][j] == 1) {
                    node nd = new node(i, j);
                    list.add(nd);
                }
            }
        }
        int N = garden.length;

        if (list.size() == N * N) return 0;

        int cnt = 0;
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};


        while (!list.isEmpty()) {

            int sizeQ = list.size();
            for (int j = 0; j < sizeQ; j++) {

                node nd = list.poll();

                int x = nd.x;
                int y = nd.y;

                for (int i = 0; i < 4; i++) {
                    int nr = x + r[i];
                    int nc = y + c[i];

                    if (nc < N && nc >= 0 && nr < N && nr >= 0) {
                        node newNd = new node(nr, nc);
                        if (garden[nr][nc] == 0) {
                            garden[nr][nc] = 1;
                            list.add(newNd);
                        }

                    }

                }
            }

            cnt++;

        }

        int answer = cnt - 1;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = solution(garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = solution(garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }
}
