class MyStack {
    Queue<Integer>q=new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());

        }
        int ans=q.peek();
        q.remove();
        return ans;
    }
    
    public int top() {
        for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());

        }
        int ans=q.peek();
        q.add(q.remove());
        return ans;
    }
    
    public boolean empty() {
        return q.size()==0;
    }
}
