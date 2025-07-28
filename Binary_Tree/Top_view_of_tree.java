public static void top(Node root){
    if(root == null) return;
    
    Queue<info> q = new LinkedList<>();
    TreeMap<Integer, Integer> map = new TreeMap<>(); // TreeMap for sorted order
    
    q.add(new info(root, 0));
    
    while(!q.isEmpty()){
        info curr = q.remove();
        
        // Only add if this horizontal distance hasn't been seen before
        if(!map.containsKey(curr.hd)){
            map.put(curr.hd, curr.node.data);
        }
        
        if(curr.node.left != null){
            q.add(new info(curr.node.left, curr.hd - 1));
        }
        if(curr.node.right != null){
            q.add(new info(curr.node.right, curr.hd + 1));
        }
    }
    
    // Print in order (TreeMap automatically sorts by key)
    for(int data : map.values()){
        System.out.println("Top view element: " + data);
    }
}
