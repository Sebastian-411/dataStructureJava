package model;

public class TreeString {
    private NodeString root;



    // search
    public NodeString search(String key){
        return search(key, root);

    }

    private NodeString search(String key, NodeString current){
        if(current == null){
            return null;
        }


        if(key.compareToIgnoreCase(current.getKey())==0){
            return current;
        } else if ( key.compareToIgnoreCase(current.getKey())<0){
            if(current.getLeft() == null){
                return null;
            } else {
                return search(key, (NodeString) current.getLeft());
            }
        } else {
            if(current.getRight() == null){
                return null;
            } else {
                return search(key, (NodeString) current.getRight());
            }
        }
    }
    // add data

    public void addNode(NodeString node){
        if(root==null){
            root = node;
        } else {
            addNode(root, node);
        }
    }

    private void addNode(NodeString current, NodeString node){
        if(node.getKey().compareToIgnoreCase(current.getKey())<0){
            if(current.getLeft() == null){
                current.setLeft(node);
                return;
            } else {
                current = (NodeString) current.getLeft();
            }
        } else {
            if(current.getRight() == null){
                current.setRight(node);
                return;
            } else {
                current = (NodeString) current.getRight();
            }
        }
        addNode(current, node);
    }

    // print data
    public String inOrder(){
        return inOrder(root);
    }

    private String inOrder(NodeString current){
        if(current == null){
            return "";
        }
        return inOrder((NodeString) current.getLeft()) + current.getScore().getScore() + "|||" + current.getScore().getName() + "\n" + inOrder((NodeString) current.getRight()) ;
    }
    
    public boolean delete(String goal){
        NodeString tmp = search(goal);
        if(tmp != null){
            if ( root.getKey().equals(goal) ){
                if ( root.getRight() != null && root.getLeft() != null ){
                    root = (NodeString) root.getRight();
                    addNode((NodeString) tmp.getLeft());
                    return true;
                } else if ( root.getRight() == null && root.getLeft() == null ){
                    return false;
                } else {
                    if ( root.getLeft() == null ){
                        root = (NodeString) root.getRight();
                    } else {
                        root = (NodeString) root.getLeft();

                    }
                    return true;
                }
            } else {
                return delete(tmp, root);

            }
        }
        return false;
    }

    private boolean delete(NodeString goal, NodeString current){
        NodeString tmp = null;
        if ( goal.getKey().compareToIgnoreCase(current.getKey()) < 0){
            if ( goal.getKey().equals(((NodeString)current.getLeft()).getKey())){
                tmp = (NodeString) current.getRight();
                current.setLeft(current.getLeft().getLeft());
                return true;
            } else {
                return delete(goal, (NodeString) current.getLeft());
            }
        } else if ( goal.getKey().compareToIgnoreCase(current.getKey()) > 0 ){
            if ( goal.getKey().equals(((NodeString)current.getRight()).getKey())){
                tmp = (NodeString) current.getLeft();
                current.setLeft(current.getRight().getRight());
                return true;
            } else {
                return delete(goal, (NodeString) current.getRight());
            }
        }
        if ( tmp != null ){
            addNode(tmp);
        }
        return false;
    }
    
}
