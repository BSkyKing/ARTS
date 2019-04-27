package leetcode.btj.week4;

/**
 * 写一个自己的单链
 */
public class MyLink <E>{

    /**头部节点*/
    private Node<E> head;

    /** 尾部的节点*/
    private Node<E> tail;

    /**单链的容量*/
    private int size;


    private class Node<E> {
        private E t;
        private Node<E> next ;

        public Node(E t) {
            this.t = t;
        }
    }

    public void add(E t) {
        Node<E> node = new Node(t);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size ++;
    }

    public E getIndex(int index) {
        checkIndex(index);
        return node(index);
    }

    public void reverse() {
        Node<E> temp = head;
        head = reverse(head);
        tail = temp;
        tail.next = null;
    }

    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.t;
    }

    //通过递归的方式
//    private Node<E> reverse(Node<E> node) {
//        if (node == null || node.next == null) {
//            return node;
//        }
//        Node<E> lastNode = reverse(node.next);
//        node.next.next = node;
//        node.next = null;
//        return lastNode;
//    }

    private Node<E> reverse(Node<E> node) {

        Node<E> pre = null;
        Node<E> next ;
        while (node != null) {
          next = node.next;
          node.next = pre;
          pre = node;
          node = next;
        }
        return pre;
    }


    public void remove(int index) {
        checkIndex(index);
        Node<E> temp = head;
        Node<E> before = null;
        int i = 0;
        while (i != index) {
            before = temp;
            temp = temp.next;
            i ++;
        }
        if (before != null) {
            before.next = temp.next;
        } else {
            head = temp.next;
        }
        size --;
    }

    private E node(int index) {
        int i = 0;
        Node<E> temp = head;
        while (index != i) {
            temp = temp.next;
            i ++ ;
        }
        return temp.t;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> temp = head;
        while (temp != null) {
            sb.append(temp.t.toString()).append(" ");
            temp = temp.next;
        }
        return sb.toString();
    }
}
