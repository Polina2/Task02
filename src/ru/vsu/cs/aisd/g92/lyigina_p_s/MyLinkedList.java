package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class MyLinkedList<T> {
    private class ListNode {
        private T value;
        private ListNode next;

        public ListNode(T value, ListNode next){
            this.value = value;
            this.next = next;
        }

        public ListNode(T value){
            this(value, null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T value) {

    }

    public void addLast(T value) {

    }

    public void insert(T value, int index) {

    }

    public void removeFirst() {

    }

    public void removeLast() {

    }

    public void remove(int index) {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return null;
    }
}
