/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-19 : AM 10:36
 */

package ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //  enqueue
        //  offer, add - enqueue에 해당하는 메소드
        queue.offer(1);
        queue.add(2);
        //  dequeue
        //  remove, poll - dequeue에 해당하는 메소드
        //  Queue가 비어있다면
        //  poll - null을 반환, remove - 예외 발생
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        //  peek
        //  element, peek - peek에 해당하는 메소드
        //  Queue가 비어있다면
        //  peek - null을 반환, element - 예외 발생
        System.out.println(queue.peek());
        System.out.println(queue.element());
    }
}
