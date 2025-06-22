public  class  array_stack{
    public static class arrayst{
    int front =-1;
    int rear=-1;
    int size=0;
    int[]arr=new int[6];
    public void add(int val){
        if(front==-1){
           front =0;
           rear =0;
           arr[rear]=val;
           size++;
           return;
        }
        if(size==arr.length){
            System.out.println("Stack is full");
            return;
        }
        arr[++rear]=val;
        size++;
    }
    public int pop(){
        if(size==0){
            System.out.println("Stack is Empty");
            return -1;
        }
        int val=arr[rear];
        rear--;
        size--;
        return val;
    }
    public int peek(){
        if(size==0)return -1;
        return arr[rear];
    }
    public void display(){
        if(size==0){
            System.out.println("Stack is Empty");
            return;
        }
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public boolean isEmpty(){
        return size==0;
    }
    }
    public static void main(String[] args) {
        arrayst st=new arrayst();
        st.add(6);
        st.add(7);
        st.add(8);
        st.display();
        System.out.println(st.pop());
        st.display();
        System.out.println(st.size);
        st.add(8);
        st.add(9);
        st.add(10);
        st.add(11);
        st.display();
        st.add(8);
        st.pop();
        st.display();
        System.out.println(st.peek());
        
    }
}
