/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 AM 9:23
 */

package topo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  선수과목
//  https://www.acmicpc.net/problem/14567
public class Bj14567 {
/*
3 2
2 3
1 2
*/

/*
6 4
1 2
1 3
2 5
4 5
*/
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj14567().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(br.readLine());
        int lectureCount = Integer.parseInt(infoToken.nextToken());
        int preReqs = Integer.parseInt(infoToken.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < lectureCount + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < preReqs; i++) {
            StringTokenizer reqToken = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(reqToken.nextToken());
            int end = Integer.parseInt(reqToken.nextToken());
            adjList.get(start).add(end);
        }

        //  1. 진입 차수 정리
        //      수업의 시작 수가 1이므로, lectureCount + 1을 해줌
        int[] inDegrees = new int[lectureCount + 1];
        for (List<Integer> neighbors : adjList) {
            for (Integer neighbor : neighbors) {
                inDegrees[neighbor]++;
            }
        }

        //  2. 진입 차수에 따른 시작 정점 결정
        //      현재 정점까지 얼마나 걸리는지
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < lectureCount + 1; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(new int[] {i, 1});
            }
        }

        //  3. Queue를 가지고 순회
        //      이때 Queue에 Queue에 담기는 시점에 방문하고 있던 정점의
        //      소요 시간 정보를 같이 담는다.
        int[] firstSem = new int[lectureCount + 1];
        while (!queue.isEmpty()) {
            int[] lecture = queue.poll();
            int node = lecture[0];
            int semester = lecture[1];
            firstSem[node] = semester;

            for (Integer nextLec : adjList.get(node)) {
                inDegrees[nextLec]--;
                if (inDegrees[nextLec] == 0) {
                    queue.offer(new int[]{nextLec, semester + 1});
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < lectureCount + 1; i++) {
            answer.append(firstSem[i]).append(' ');
        }

        return answer.toString();
    }
}
