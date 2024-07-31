package lianbiao;

public class Linklist<E> {

    private Node<E> head = new Node<>(null);
    private int size;

    public  void add(E element,int index){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置错误"+ size);
        Node<E> prev = head;  //prev是一个节点指针，指向链表头；
        for (int i = 0; i <index ; i++)
            prev = prev.next;   /* prev.next是对prev下一个节点的引用，prev只是指向待插入节点，
                                   其本质还是指向待插入节点的前一个节点，这样下面的代码就很好理解了*/
        Node<E> node = new Node<>(element);
        node.next = prev.next;
        prev.next = node;
        size++;


    }

    public E remove(int index){
        if(index < 0 || index > size - 1)   //同样的，先判断位置是否合法
            throw new IndexOutOfBoundsException("删除位置非法，合法的删除位置为：0 ~ "+(size - 1));
        Node<E> prev = head;
        for (int i = 0; i < index; i++)   //同样需要先找到前驱结点
            prev = prev.next;
        E e = prev.next.element;   //先把待删除结点存放的元素取出来
        prev.next = prev.next.next;  //可以删了
        size--;   //记得size--
        return e;
    }

    public void get(int index){
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("超出范围了");
        Node<E> node = head;
        while(index-- >=0){
            node = node.next;
        }
        System.out.println(node.element);

    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node<E> node = head.next;
        while(node != null){
            builder.append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString();
    }

    private static class Node<E>{
        E element;
        Node<E> next  ;


        public Node(E element) {
            this.element = element;
        }
    }




}

/* public void inset(E obj){
    int index = hash(obj);
    Node<E> head = TABLE[index];
    Node<E> node = new Node<>(obj);
    node.next = head.next;
    head.next = node;

    这个是一直插入到头部（是哈希表的代码）
} */