
import java.util.ArrayList;

public class heap<T extends Comparable<T>>{

    private ArrayList<T>list;

    public heap(){
      list=new ArrayList<>();
    }

    private  void swap(int first,int second){
        T temp=list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int left(int index){
        return (index*2)+1;
    }
    private int right(int index){
        return (index*2)+2;
    }

    public void insert(T val){
        list.add(val);
        upheap(list.size()-1);
    }

    private void upheap(int index){
      if(index==0||list.get(parent(index)).compareTo(list.get(index))<0)return;
      else{
        swap(index,parent(index));
        upheap(parent(index));
      }
    }
    
    private void downheap(int index){
        int min=index;
        int left=left(index);
        int right=right(index);

        if(left<list.size()&&(list.get(min).compareTo(list.get(left)))>0){
            min=left;
        }
        else if(right<list.size()&&(list.get(min).compareTo(list.get(right)))>0){
            min=right;
        }

        if(min!=index){
            swap(index, min);
            downheap(min);
        }

    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Heap is Empty");
           
        }
        T temp=list.get(0);

        T last=list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downheap(0);
        }

        
        return temp;


    }

    public ArrayList<T> heapsort() throws Exception{
        ArrayList<T>sorted = new ArrayList<>();
        while(!list.isEmpty()){
            sorted.add(this.remove());
        }
        return sorted;
    }


}
