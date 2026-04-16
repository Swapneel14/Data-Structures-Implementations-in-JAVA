class Solution {
    HashMap<Node,Node>map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        if(map.containsKey(node))return map.get(node);
        Node ans = new Node(node.val);
         map.put(node,ans);

        for(Node curr : node.neighbors){
            
            ans.neighbors.add(cloneGraph(curr));
        }

       

        return ans;
    }
}
