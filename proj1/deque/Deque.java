package deque;

public interface Deque<Data> {
    public void addFirst(Data item);
    public void addLast(Data item);
    //default添加默认实现的方法
    default boolean isEmpty(){
        return size() == 0;
    }
    public int size();
    public void printDeque();
    public Data removeFirst();
    public Data removeLast();
    public Data get(int index);
}
