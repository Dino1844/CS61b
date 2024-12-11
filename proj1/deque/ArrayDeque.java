package deque;

public class ArrayDeque<Data> implements Deque<Data> {
    private Data[] a;
    private int size;
    private int maxSize;
    private int front;
    private int rear;

    public ArrayDeque() {
        a = (Data[]) new Object[8];
        size = 0;
        maxSize = 8;
        front = 0;
        rear = 0;
    }

    private void resize(int len) {
        Data[] reArray = (Data[]) new Object[len];
        for (int i = 0; i < size; i++) {
            reArray[i] = a[(front + i) % maxSize];
        }
        a = reArray;
        front = 0;
        rear = size;
        maxSize = len;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(a[(front + i) % maxSize]);
            if (i < size - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    @Override
    public Data get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return a[(front + index) % maxSize];
    }

    @Override
    public void addLast(Data data) {
        if (size == maxSize) {
            resize(2 * maxSize);
        }
        a[rear] = data;
        rear = (rear + 1) % maxSize;
        size++;
    }

    @Override
    public Data removeLast() {
        if (size == 0) {
            return null;
        }
        rear = (rear - 1 + maxSize) % maxSize;
        Data tmp = a[rear];
        a[rear] = null;
        size--;
        if (size < maxSize / 4 && maxSize > 8) {
            resize(maxSize / 2);
        }
        return tmp;
    }

    @Override
    public void addFirst(Data data) {
        if (size == maxSize) {
            resize(2 * maxSize);
        }
        front = (front - 1 + maxSize) % maxSize;
        a[front] = data;
        size++;
    }

    @Override
    public Data removeFirst() {
        if (size == 0) {
            return null;
        }
        Data tmp = a[front];
        a[front] = null;
        front = (front + 1) % maxSize;
        size--;
        if (size < maxSize / 4 && maxSize > 8) {
            resize(maxSize / 2);
        }
        return tmp;
    }

    public static void main(String[] args) {
        ArrayDeque<String> d = new ArrayDeque<>();
        d.addLast("a");
        d.addLast("b");
        d.addLast("c");
        d.addFirst("tmp");
        d.removeFirst();
        d.printDeque();
    }
}