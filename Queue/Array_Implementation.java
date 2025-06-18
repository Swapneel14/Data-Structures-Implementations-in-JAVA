public  class Array_Implementation{
public static class arrayq{
    int front =-1;
    int rear=-1;
    int size=0;
    int[]arr=new int[6];
    public void add(int val){
        if(rear==arr.length-1){
            System.out.println("Array Full");
            return;
        }
        if(front==-1){
            front=0;
            rear=0;
            arr[rear]=val;
        }
        else{
            arr[++rear]=val;
        }
        size++;

    }
    public int remove(){
         if(size==0){
            System.out.println("Queue is Empty");
            return -1;
        }
        front++;
        size--;
        return arr[front-1];
    }
    public int peek(){
        if(size==0){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }
    public void display(){
        if(size==0)System.out.println("Empty");
        else{
            for(int i=front;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
            
        }
        System.out.println();
    }
}
   public static void main(String[]args){
    arrayq q=new arrayq();
    q.add(1);
    q.add(3);
    q.add(4);
    q.add(5);
    q.add(6);
    q.display();
   int x= q.remove();
    q.display();
    System.out.println(x);
    int t=q.peek();
    System.out.println(t);

    
   }
}
