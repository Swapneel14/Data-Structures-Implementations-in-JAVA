
import java.util.ArrayList;

public class main{
    public static void main(String[] args) throws Exception{
        heap<Integer>h1=new heap<>();
        h1.insert(2);
        h1.insert(8);
        h1.insert(9);
        h1.insert(1);
        h1.insert(23);
        
        ArrayList<Integer>sorted = new ArrayList<>(h1.heapsort());
        System.out.println(sorted);//1,2,8,9,23 TC-O(nlog(n))
}
}
