/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-13 : AM 11:23
 */

package ds.stack.self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchSelf {

    public static void main(String[] args) throws IOException {
        new DepthFirstSearchSelf().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  첫 입력은 정점의 갯수
        int maxNodes = Integer.parseInt(br.readLine());
        //  정점간 연결 정보
        int[][] edgeMap = new int[maxNodes + 1][maxNodes + 1];
        int[][] edgeInfo = new int[maxNodes + 1][maxNodes + 1];

        //  1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
        String[] edges = br.readLine().split(" ");
        for (int i = 0; i < edges.length / 2; i++) {
            int leftNode = Integer.parseInt(edges[i * 2]);  //  0, 2, 4, ...
            int rightNode = Integer.parseInt(edges[i * 2 + 1]); //  1, 3, 5, ...
            edgeMap[leftNode][rightNode] = 1;
            edgeMap[rightNode][leftNode] = 1;
        }

        //  다음에 방문할 점들을 담아두는 스택
        Stack<Integer> toVisit = new Stack<>();
        //  방문을 기록하는 용도의 배열
        boolean[] visited = new boolean[maxNodes + 1];
        //  여기부터 DFS

        //  첫 벙문 대상 선정 (1)
        int next = 1;
        //  대상을 스택에 push
        toVisit.push(next);
        //  스택이 빌때까지 반복하는 while
        //  TODO 순회한 노드들의 리스트를 출력해야할 경우 while 반복시마다 List에 추가
        Deque<Integer> visitHistory = new ArrayDeque<>();

        while (!toVisit.empty()) {
            //  TODO 다음 방문할 곳을 가져온다. (pop)
            next = toVisit.pop();
            visitHistory.offer(next);
            //  TODO 이미 방문했다면 다음곳으로 간다. (pop)
            if (visited[next]) {
                continue;
            }
            //  TODO 방문했다 표시한다.
            visited[next] = true;

            //  TODO 요부분은 문제에 따라 다르다

            //  TODO 다음 방문 대상을 검색해서, 스택에 푸쉬한다. (push)
            for(int i = 1; i < maxNodes + 1; i++) {   //  TODO
                //  TODO 해당 정점에 도달할 수 있고, 아직 방문하지 않았다면
                if (edgeMap[next][i] == 1 && !visited[i]) {
                    //  TODO 다음에 방문할 곳으로 스택에 푸쉬
                    toVisit.push(i);
                }
            }
        }

        //  TODO 답을 출력한다.
        System.out.println(visitHistory);
    }
}
