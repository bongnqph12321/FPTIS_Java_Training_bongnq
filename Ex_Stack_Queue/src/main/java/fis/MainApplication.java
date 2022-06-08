package fis;



import fis.model.Books;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MainApplication {
    public static void main(String[] args) {
        Queue<Books> queue = new PriorityQueue<>();
        Stack<String> stack = new Stack<>();
        Books b1 = new Books(1, "Đắc Nhân Tâm", "Dale Carnegie", " Simon and Schuster ", 8);
        Books b2 = new Books(2, "Nhà Gỉa Kim", " Paulo Coelho", "  Paulo Coelho ", 20);
        Books b3 = new Books(3, "Clean code", "Robert Martin", " Robert Martin ", 7);
        Books b4 = new Books(4, "100 bài code thiếu nhi", "Phạm Huy Hoàng", " Huy Hoàng ", 5);
        Books b5 = new Books(5, "bao giờ bán được 100 gói mè", "Phạm Thành Long", " Phạm Thành Long ", 50);

        queue.add(b1);
        queue.add(b2);
        queue.add(b3);
        queue.offer(b4);
        queue.offer(b5);

        System.out.println("Danh sách các loại sách:");
        // Traversing queue elements
        for (Books b : queue) {
            System.out.println(b);
        }

        System.out.println("Những sách sẽ bị xóa:");
        System.out.println(queue.poll());
        System.out.println(queue.remove());

        System.out.println("Sau khi xóa");
        for (Books b : queue) {
            System.out.println(b);
        }

        //su dung stack
       stack.push("Sách đắc nhân tâm ");
        stack.push("Sách nhà giả kim ");
        stack.push("sách clean code");

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Final Stack: " + stack);
    }
}
