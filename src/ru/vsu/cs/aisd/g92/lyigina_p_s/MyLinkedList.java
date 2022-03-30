package ru.vsu.cs.aisd.g92.lyigina_p_s;

import java.util.Iterator;

public class MyLinkedList implements Iterable<Student> {
    @Override
    public Iterator<Student> iterator() {
        class MyLinkedListIterator implements Iterator<Student> {
            ListNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Student next() {
                Student value = current.getValue();
                current = current.getNext();
                return value;
            }
        }
        return new MyLinkedListIterator();
    }

    private class ListNode {
        private Student value;
        private ListNode next;

        public ListNode(Student value, ListNode next){
            this.value = value;
            this.next = next;
        }

        public ListNode(Student value){
            this(value, null);
        }

        public Student getValue() {
            return value;
        }

        public void setValue(Student value) {
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

    public void addFirst(Student value) {
        if (isEmpty()) {
            head = tail = new ListNode(value);
        } else {
            head = new ListNode(value, head);
        }
        size++;
    }

    public void addLast(Student value) {
        if (isEmpty())
            head = tail = new ListNode(value);
        else {
            tail.setNext(new ListNode(value));
            tail = tail.getNext();
        }
        size++;
    }

    public void insert(Student value, int index) {
        if (index == 0)
            addFirst(value);
        else if (index == size)
            addLast(value);
        else {
            ListNode node = getNode(index - 1);
            node.setNext(new ListNode(value, node.getNext()));
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("List is empty");
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.getNext();
        }
        size--;
    }

    public void removeLast() {
        if (size < 2)
            removeFirst();
        else {
            remove(size-1);
        }
        size--;
    }

    public void remove(int index) {
        if (index == size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (index == 0)
            removeFirst();
        else {
            ListNode node = getNode(index - 1);
            node.setNext(node.getNext().getNext());
            if (node.getNext() == null)
                tail = node;
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Student get(int index) {
        return getNode(index).getValue();
    }

    protected ListNode getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        ListNode current = head;
        int count = 0;
        while (count < index) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    public Student getFirst() {
        return head.getValue();
    }

    public Student getLast() {
        return tail.getValue();
    }

    public void swap(ListNode prev1, ListNode prev2) {
        ListNode tmp = prev2.getNext().getNext();
        prev2.getNext().setNext(prev1.getNext().getNext());
        prev1.getNext().setNext(tmp);
        tmp = prev1.getNext();
        prev1.setNext(prev2.getNext());
        prev2.setNext(tmp);
    }

    public void sortByCourse() {
        ListNode[] heads = new ListNode[6];
        ListNode[] tails = new ListNode[6];

        ListNode cur = head;
        //ListNode prev = null;
        //int count = 0;
        if (cur == null)
            return;
        while (cur != null) {
            if (heads[cur.getValue().getCourse()-1] == null) {
                heads[cur.getValue().getCourse()-1] = cur;
                tails[cur.getValue().getCourse()-1] = cur;
            } else {
                tails[cur.getValue().getCourse()-1].setNext(cur);
                tails[cur.getValue().getCourse()-1] = cur;
                //move(heads[cur.getValue().getCourse()-1], prev);
                //if (tails[cur.getValue().getCourse()-1].equals(heads[cur.getValue().getCourse()-1]))
                //    tails[cur.getValue().getCourse()-1] = cur;
            }
            //prev = cur;
            cur = cur.getNext();
            //count++;
        }

        int i = 0;
        while (heads[i] == null) {
            i++;
        }
        head = heads[i];
        int j = i+1;
        while (j < 6) {
            if (heads[j] == null)
                j++;
            else {
                tails[i].setNext(heads[j]);
                tail = tails[j];
                i = j;
                j++;
            }
        }
        tail.setNext(null);
    }

    private void move(ListNode prev1, ListNode prev2) {
        ListNode tmp = prev2.getNext();
        prev2.setNext(tmp.getNext());
        tmp.setNext(prev1.getNext());
        prev1.setNext(tmp);
    }

    public int getSize1() {
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.getNext();
        }
        return i;
    }
}
