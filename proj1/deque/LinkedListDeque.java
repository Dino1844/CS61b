package deque;

public class LinkedListDeque<Data> implements Deque<Data> {
    // Node 子类
    public class Node<Data> {
        private Data data;
        private Node<Data> before;
        private Node<Data> next;

        public Node(Data data) {
            this.before = null;
            this.data = data;
            this.next = null;
        }


    }
    //关键参数
    private Node<Data> headSentinel;
    private Node<Data> lastSentinel;
    private int size;
    //获得长度
    @Override
    public int size() {
        return size;
    }
    // link初始化
    public LinkedListDeque() {
        this.headSentinel = new Node<>(null); // 哨兵节点不存储数据
        this.lastSentinel = new Node<>(null); // 哨兵节点不存储数据
        headSentinel.next = lastSentinel;
        lastSentinel.before = headSentinel;
        this.size = 0;
    }
    //添加第一个
    @Override
    public void addFirst(Data data) {
        Node<Data> addNode = new Node<>(data);
        addNode.next = headSentinel.next;
        addNode.before = headSentinel;
        headSentinel.next = addNode;
        addNode.next.before = addNode;
        size += 1;
    }
    //去除第一个
    @Override
    public Data removeFirst(){
        if(size<=0){
            return null;
        }
        Node<Data> node = headSentinel.next;
        node.before = null;
        headSentinel.next = node.next;
        node.next = null;
        size -= 1;
        return node.data;
    }
    // 末尾添加
    @Override
    public void addLast(Data data) {
        Node<Data> addNode = new Node<>(data);

        Node<Data> lastNode = lastSentinel.before; // 找到当前最后一个节点

        lastNode.next = addNode;
        addNode.before = lastNode;

        addNode.next = lastSentinel;
        lastSentinel.before = addNode;

        size += 1;
    }
    //末尾删除
    @Override
    public Data removeLast() {
        if(size == 0) {
            System.out.println("List is empty, can't remove last");
            return null;
        }
        Node<Data> lastNode = lastSentinel.before;
        Node<Data> last2Node = lastNode.before;
        //java自动回收空间

        last2Node.next = lastSentinel;
        lastSentinel.before = last2Node;
        lastNode.next = null;
        lastNode.before = null;
        size -= 1;
        return lastNode.data;
    }
    //获得第n个盒子
    @Override
    public Data get(int index){
        if(index>=size || index<=0){
            System.out.println("List is empty, can't get node");
            return null;
        }
        Node<Data> now;
        if(index>=size/2){
            int now_num = size+1;
            now = lastSentinel;
            while(now_num != index){
                now_num--;
                now = now.before;
            }
        }else{
            int now_num = 0;
            now = headSentinel;
            while(now_num != index){
                now_num++;
                now = now.next;
            }
        }
        return now.data;
    }
    //使用递归方法获得第n个盒子
    public Data getRecursive(int index) {
        return getRecursiveHelper(index,headSentinel.next);
    }
    private Data getRecursiveHelper(int index ,Node<Data> head){
        if(index == 1){
            return head.data;
        }
        return getRecursiveHelper(index-1, head.next);
    }
    //打印列表
    @Override
    public void printDeque(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        Node<Data> now = headSentinel;
        while(now.next != lastSentinel.before){
            now = now.next;
            System.out.print(now.data + "->");
        }
        now = now.next;
        System.out.println(now.data);
    }
    // Main Test
    public static void main(String[] args) {
        LinkedListDeque<String> list = new LinkedListDeque<>();
        list.addLast("a");

        list.addLast("b");
        list.addLast("c");
        list.printDeque();
    }
}
