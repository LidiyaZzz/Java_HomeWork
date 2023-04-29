/*
Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.
 */

import java.util.LinkedList;

public class task2 {
    public static LinkedList<String> queue = new LinkedList();

    public static void main(String[] args) {

        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);

        System.out.println(queue);

        dequeue();
        System.out.println(queue);

        first();
        System.out.println(queue);
    }

    public static void  enqueue(Object elem) {
//        помещает элемент в конец очереди
        queue.add(String.valueOf(elem));
    }

    public static void dequeue() {
//        возвращает первый элемент из очереди и удаляет его
        System.out.println(queue.pollFirst());
    }

    public static void first() {
//        возвращает первый элемент из очереди, не удаляя его
        System.out.println(queue.peekFirst());
    }
}
