package com.richard.itview;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);
        Node node1 = new Node("one", 1);
        Node node2 = new Node("two", 2);
        Node node3 = new Node("three", 3);
        Node node4 = new Node("four", 4);
        Node node5 = new Node("five", 5);
        Node node6 = new Node("six", 6);
        q.offer(node1);
        q.offer(node2);
        q.offer(node3);
        q.offer(node4);
        q.offer(node5);
        q.offer(node6);
//        Node add = q.poll();
//        add.count = 1000;
//        q.offer(add);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.println(curr.name + curr.count);
        }

    }
}

class Node {
    String name;
    int count;
    public Node(String name, Integer count) {
        this.name = name;
        this.count = count;
    }
}
