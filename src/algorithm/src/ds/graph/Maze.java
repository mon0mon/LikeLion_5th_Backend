/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-27
 */

package ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        System.out.println(new Maze().solution(new int[][]{
            {0, 0, 0, 0, 0, 3},
            {1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {2, 1, 1, 0, 1, 1}
        }));
    }

    public int solution(int[][] maze) {
        // BFS 로직을 활용하는데,
        //  다음에 접근할 수 있는 칸을 maze의 가로 세로 크기 이내의 인접한 칸
        //  을 기준으로 판단

        //  int[]를 담는 Queue, {x, y, 여태까지 이동거리}
        Queue<int[]> visitNext = new LinkedList<>();
        //  미로에서 이미 도달한 적 있는 칸임을 나타내기 위한 visited 이차원 배열
        boolean[][] visited = new boolean[6][6];
        visitNext.offer(new int[]{5, 0, 0});
        int answer = -1;

        //  BFS 시작
        //  Queue가 비어있지 않은 동안
        while (!visitNext.isEmpty()) {
            //  다음에 갈 곳을 Queue에서 꺼낸다.
            int[] next = visitNext.poll();
            int nowX = next[0];
            int nowY = next[1];
            int steps = next[2];
            //  현재 칸이 3이라면,
            if (maze[nowX][nowY] == 3) {
                answer = steps;
                return answer;
            }
            visited[nowX][nowY] = true;

            //  4개의 방향을 확인한다.
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (checkBounds(nextX, nextY)
                    && (maze[nextX][nextY] == 0 || maze[nextX][nextY] == 3)
                    && !visited[nextX][nextY])
                        visitNext.offer(new int[] {nextX, nextY, steps+1});
            }

//            //  위
//            int[] top = new int[]{nowX - 1, nowY, steps + 1};
//            //  1. 미로의 범위를 벗어나지 않는지
//            //  top[0], top[1]이 -1보다는 크고, 6보다는 작아야 한다.
//            if (checkBounds(top[0], top[1])
//                //  2. 미로에서 진행 가능한 칸인지 (0 또는 3)
//                && maze[top[0]][top[1]] == 0 || maze[top[0]][top[1]] == 3
//                //  3. 아직 방문한 적 없는지
//                && !visited[top[0]][top[1]]) {
//                visitNext.offer(top);
//            }

        }

        return answer;
    }

    //  미로의 범위 내에 있는지 검사하는 메소드
    private boolean checkBounds(int x, int y) {
        return -1 < x && x < 6 && -1 < y && y < 6;
    }
}
