package deque;

public class ArrayDeque<Data> implements Deque<Data> {
    private Data[] a;
    private int size;
    private int  maxSize;
    public ArrayDeque() {
        a = (Data[]) new Object[8];
        size = 0;
        maxSize = 8;
    }
    private void resize(int len){
        Data[] reArray = (Data[]) new Object[len];
        System.arraycopy(a, 0, reArray, 0, Math.min(size, len));
        a = reArray;
        maxSize = len;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        for(int i = 0; i < size-1;i++){
            System.out.print(a[i]+"->");
        }
        System.out.println(a[size-1]);
    }
    @Override
    public Data get(int index) {
        return a[index];
    }
    @Override
    public void addLast(Data data) {
        if(maxSize <= size){
            resize(2*maxSize);
        }
        a[size++] = data;
    }
    @Override
    public Data removeLast() {
        Data tmp = a[--size];

        if(size < maxSize/2){
            resize(maxSize/2);
        }
        return tmp;
    }
    @Override
    public void addFirst(Data data) {
        if(maxSize <= size){
            resize(2*maxSize);
        }
        Data[] tmp = (Data[]) new Object[maxSize+1];
        System.arraycopy(a, 0, tmp, 1, size);
        tmp[0] = data;
        a = tmp;
        size ++;
    }
    @Override
    public Data removeFirst() {
        if(size < maxSize/2){
            resize(maxSize/2);
        }
        Data tmp = a[0];
        Data[] b = (Data[]) new Object[size-1];
        System.arraycopy(a, 1, b, 0,size-1);
        size--;
        a = b;
        return tmp;


    }



    public static void main(String[] args) {
        ArrayDeque<String> d = new ArrayDeque<String>();
        d.addLast("a");
        d.addLast("b");
        d.addLast("c");
        d.addFirst("tmp");
        d.removeFirst();
        d.printDeque();
    }
}
