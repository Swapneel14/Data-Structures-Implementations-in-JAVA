public class Linked_List_Imp{
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    public static class LLq{
        Node head = null;
        Node tail = null;
        int size = 0;
        public void add(int val){
            Node temp=new Node(val);
            if(size==0){
                head=tail=temp;
            }
            else{
                tail.next=temp;
                tail=temp;
            }
            size++;
        }
        public int peek(){
          if(size==0){
            System.out.println("Queue is Empty");
            return -1;
          }
          return head.val;
        }
        public int remove(){
             if(size==0){
            System.out.println("Queue is Empty");
            return -1;
          }
          int val=head.val;
          head=head.next;
          size--;
          return val;
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is Empty");
                return;
            }
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        public boolean isEmpty(){
            return size==0;
        }

    }
    public static void main(String[] args) {
        LLq q= new LLq();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.peek());//1
        q.display(); // 1 2 3 4
        q.remove(); // removes 1
        q.display(); // 2 3 4
        q.add(5);
        q.display(); // 2 3 4 5
        System.out.println(q.isEmpty()); // false
        System.out.println(q.size);
    }
}
