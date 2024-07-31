package sunxubiao;

public class ArrayList <E>{
    private int capacity = 10;
    private int size = 0;
    private Object[] array = new Object[capacity];

    public void add(E element,int index){
        if(index < 0 || index > size)    //插入之前先判断插入位置是否合法
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);

        if(size >= capacity){
            int newcapacity = capacity + (capacity >> 1);
            Object[] newArray = new Object[newcapacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
            capacity = newcapacity;
        }

        for (int i = size; i > index; i--)
            array[i] = array[i-1];
        array[index] = element;
        size++;

    }

    public void remove(int index){
        if(index < 0 || index >size-1){
            throw new IndexOutOfBoundsException("删除位置错误");
        }
        for (int i = index; i <size ; i++) {
            array[i] = array[i+1];
            size--;
        }

    }

    public  void get(int index){
        if(index < 0 || index >size-1){
            throw new IndexOutOfBoundsException("位置错误");
        }

        System.out.println(array[index]);
    }

    public String toString(){
        System.out.println(size);
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<size;i++) builder.append(array[i]).append(" ");

        return builder.toString();

    }
}
