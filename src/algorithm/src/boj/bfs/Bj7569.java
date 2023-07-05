/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-03 AM 9:16
 */

package boj.bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//  https://www.acmicpc.net/problem/7569
public class Bj7569 {

    //  x의 변화
    private final int[] dx = {-1, 1, 0, 0, 0, 0};
    //  y의 변화
    private final int[] dy = {0, 0, -1, 1, 0, 0};
    //  h의 변화
    private final int[] dh = {0, 0, 0, 0, -1, 1};
    //  상자의 크기
    private int x;
    private int y;
    private int h;

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj7569().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  첫줄 `X Y H`가 들어온다.
        StringTokenizer infoParser = new StringTokenizer(br.readLine());
        x = Integer.parseInt(infoParser.nextToken());
        y = Integer.parseInt(infoParser.nextToken());
        h = Integer.parseInt(infoParser.nextToken());
        //  토마토 정보를 담을 상자 3차원 배열
        int[][][] tomatoRack = new int[h][y][x];

        //  데이터 입력 받으면서 첫번째 방문 위치 찾기
        Queue<int[]> toVisit = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                StringTokenizer rowParser = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    //  토마토 정보 받아오기
                    int tomato = Integer.parseInt(rowParser.nextToken());
                    tomatoRack[i][j][k] = tomato;
                    if (tomato == 1) {
                        //  이미 익은 토마토들 부터 시작
                        toVisit.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }
        //  총 일수 저장용 변수
        int days = 0;
        //  BFS 시작
        while (!toVisit.isEmpty()) {
            int[] tomato = toVisit.poll();
            //  이번에 확인한 토마토가 익은 시점이 현재 기록된 시간보다 늦을 경우 갱신한다.
            if (days != tomato[3]) {
                days = tomato[3];
            }
            //  상화좌우 + 위아래 체크
            for (int i = 0; i < 6; i++) {
                //  다음 확인 좌표
                int nextH = tomato[0] + dh[i];
                int nextY = tomato[1] + dy[i];
                int nextX = tomato[2] + dx[i];
                //  1. 영역을 벗어나지 않는다.
                if (checkBounds(nextH, nextY, nextX)
                    //  2. 익지 않은 토마토이다.
                    && tomatoRack[nextH][nextY][nextX] == 0) {
                    //  토마토를 익음으로 표시
                    tomatoRack[nextH][nextY][nextX] = 1;
                    //  다음날에 이 토마토는 익어있습니다.
                    toVisit.offer(new int[]{nextH, nextY, nextX, tomato[3] + 1});
                }
            }
        }

        //  익지 않은 토마토 존재 확인
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (tomatoRack[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days;
    }

    public boolean checkBounds(int h, int y, int x) {
        if (-1 >= x || this.x <= x) {
            return false;
        }

        if (-1 >= y || this.y <= y) {
            return false;
        }

        if (-1 >= h || this.h <= h) {
            return false;
        }

        return true;
    }

}
