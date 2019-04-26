package Graded;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sort {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            queue.add(s.nextInt());
        sort(queue);
    }

    // Method to sort the queue
    static void sort(Queue<Integer> queue) {
        // Write your code here
        List<Integer> list = new LinkedList<>();
        list = queue.stream()
                .sorted()
                .collect(Collectors.toList());
        queue.clear();
        list.stream().forEach(x -> {
            queue.add(x);
        });

        System.out.println(queue);
    }
}
