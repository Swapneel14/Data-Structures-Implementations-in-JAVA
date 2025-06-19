public class circular_queue_with_array{
    public static class cqa{
        int f=-1;
        int r=-1;
        int[] arr=new int[8];
        int size=0;
     public void add(int val){
        if(size==arr.length){
            System.err.println("Queue is Full");
            return;
        }
        else if(size==0){
            f=0;
            r=0;
            arr[r]=val;
        }
        else if(r==arr.length-1){
            r=0;
            arr[r]=val;
        }
        else if(r<arr.length-1){
            arr[++r]=val;
        }
       
        size++;
    }
    public int  remove(){
        int val=0;
        if(f==arr.length-1){
             val =arr[f];
            f=0;
            size--;
            return val;
        }
        
       if(size==0){
        System.out.println("Queue is Empty");
        return -1;
       }
       else if(size==arr.length){
         val=arr[f];
        if(f==arr.length-1)f=0;
        else f++;
      }
       else if(size<arr.length){
             val =arr[f];
            f++;
         }
         size--;
         return val;

    }
    public int peek(){
        if(size==0){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[f];
    }public void DisplayNormal(){
        if(size==0){
            System.out.println("Queue is Empty");
            return;
        }
        if(f<=r){
            for(int i=f;i<=r;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        if(f>r){
                for(int i=f;i<arr.length;i++){
                    System.out.print(arr[i]+" ");
                }
                for(int i=0;i<=r;i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
                return;
            }
        }
    }
    
   

    public static void main(String[] args) {
        System.out.println("hi");
        cqa q= new cqa();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.DisplayNormal();
        q.add(9);
        q.remove();
        q.add(9);
        q.DisplayNormal();
        q.remove();
        q.DisplayNormal();
        q.remove();
        q.DisplayNormal();
        q.remove();
        q.DisplayNormal();

        q.remove();
        q.DisplayNormal();
        q.remove();
        q.DisplayNormal();

        q.remove();
        q.DisplayNormal();
        q.remove();
        q.DisplayNormal();
        q.remove();
        q.DisplayNormal();
        q.add(10);
        q.add(11);
        q.add(12);
        q.add(13);

        q.DisplayNormal();
        System.out.println(q.peek());
        System.out.println(q.remove());
        q.DisplayNormal();




    }
    }
