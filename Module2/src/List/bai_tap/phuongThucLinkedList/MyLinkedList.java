package List.bai_tap.phuongThucLinkedList;

public class MyLinkedList<E> {
    private Node head;
    int size;
    private Node end;
    public MyLinkedList() {
    }
    public void add(int index, E e) throws Exception {
        if (size == 0) {
            System.out.println("0");
            head = new Node();
            head.setData(e);
        } else if (index >= size) {
            Node node = new Node();
            node.setData(e);
            this.getNode(size - 1).setNext(node);
        } else {
            Node node = new Node();
            node.setData(e);
            if(index!=0){
                Node left = this.getNode(index - 1);
                Node right = this.getNode(index);
                left.setNext(node);
                node.setNext(right);
            }else{
                Node temp = this.getNode(0);
                node.setNext(temp);
                head = node;
            }
        }
        size++;
    }
    int getSize() {
        return size;
    }
    E get(int index) {
        Node temp = head;
        int i = 0;
        do {
            System.out.println("hasnext " + i + "  " + temp.hasNext());
            if (i == index) {
                return (E) temp.getData();
            }
            i++;
            temp = temp.getNext();
        } while (i <= size);
        return null;
    }
    Node getNode(int i) {
        Node temp = head;
        int count = 0;
        do {
            if (i == count) {
                return temp;
            }
            count++;
            temp = temp.getNext();
        } while (count <= i);
        return null;
    }
}
class Node {
    private Object data;
    private Node next;
    public Node() {
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    boolean hasNext() {
        return getNext() != null;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();
        integerMyLinkedList.add(0, 1);
        integerMyLinkedList.add(0, 2);
        integerMyLinkedList.add(0, 3);
        integerMyLinkedList.add(0, 4);
        System.out.println(integerMyLinkedList.get(2));
    }
}


