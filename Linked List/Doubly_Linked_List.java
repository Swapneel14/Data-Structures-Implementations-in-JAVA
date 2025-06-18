public  class  double_LL{
    public static class  Node{
            int val;
            Node next;
            Node prev;
            Node(int val){
                this.val=val;
            }
    }
    public static void DisplayNormal(Node head){
        Node temp =head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void DisplayReverse(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.prev;
        }
         System.out.println();
    }
    public static Node addfirst(Node head,int x){
        Node t= new Node(x);
        t.next=head;
        head.prev=t;
        return t;

    }
    public static Node addLast(Node head,int x){
      Node t =new Node(x);
       Node temp=head;
    while(temp.next!=null){
        temp=temp.next;
      }
    temp.next=t;
     t.prev=temp;
     return head;
    }
    public static Node addany(Node head,int pos,int x){
        Node temp=head;
        for(int i=1;i<pos;i++){
            temp=temp.next;
        }
        Node t=new Node(x);
        t.next=temp;
        t.prev=temp.prev;
        temp.prev.next=t;
        temp.prev=t;
        return head;
    }
    public static Node deletefirst(Node head){
        return head.next;
    }
    
    public static void main(String[] args) {
        Node a=new Node(5);
        Node b= new Node(6);
        Node c= new Node(7);
        
        a.next=b;
        b.prev=a;
        b.next=c;
        c.prev=b;
        Node ans=deletefirst(a);
        DisplayNormal(ans);
        
        


    }
}
