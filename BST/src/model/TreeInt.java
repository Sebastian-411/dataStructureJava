package model;

public class TreeInt {
    private NodeInt root;



    // search
    public NodeInt search(int key){
        return search(key, root);

    }

    private NodeInt search(int key, NodeInt current){
        if(current == null){
            return null;
        }
        if(key == current.getKey()){
            return current;
        } else if ( key < (current.getKey())){
            if(current.getLeft() == null){
                return null;
            } else {
                return search(key, (NodeInt) current.getLeft());
            }
        } else {
            if(current.getRight() == null){
                return null;
            } else {
                return search(key, (NodeInt) current.getRight());
            }
        }
    }
    // add data

    public void addNode(NodeInt node){
        if(root==null){
            root = node;
        } else {
            addNode(root, node);
        }
    }

    private void addNode(NodeInt current, NodeInt node){
        if(node.getKey() < (current.getKey())){
            if(current.getLeft() == null){
                current.setLeft(node);
                return;
            } else {
                current = (NodeInt) current.getLeft();
            }
        } else {
            if(current.getRight() == null){
                current.setRight(node);
                return;
            } else {
                current = (NodeInt) current.getRight();
            }
        }
        addNode(current, node);
    }

    // print data
    public String inOrder(){
        return inOrder(root);
    }

    private String inOrder(NodeInt current){
        if(current == null){
            return "";
        }
        return inOrder((NodeInt) current.getLeft()) + current.getScore().getScore() + "|||" + current.getScore().getName() + "\n" + inOrder((NodeInt) current.getRight()) ;
    }

    public boolean delete(int goal){
        NodeInt tmp = search(goal);
        if(tmp != null){
            if ( root.getKey() == (goal) ){
                if ( root.getRight() != null && root.getLeft() != null ){
                    root = (NodeInt) root.getRight();
                    addNode((NodeInt) tmp.getLeft());
                    return true;
                } else if ( root.getRight() == null && root.getLeft() == null ){
                    return false;
                } else {
                    if ( root.getLeft() == null ){
                        root = (NodeInt) root.getRight();
                    } else {
                        root = (NodeInt) root.getLeft();

                    }
                    return true;
                }
            } else {
                return delete(tmp, root);

            }
        }
        return false;
    }

    private boolean delete(NodeInt goal, NodeInt current){
        NodeInt tmp = null;
        if ( goal.getKey() < (current.getKey())){
            if ( goal.getKey() == (((NodeInt)current.getLeft()).getKey())){
                tmp = (NodeInt) current.getRight();
                current.setLeft(current.getLeft().getLeft());
                return true;
            } else {
                return delete(goal, (NodeInt) current.getLeft());
            }
        } else if ( goal.getKey() > ( current).getKey()){
            if ( goal.getKey() == ((NodeInt)current.getRight()).getKey()){
                tmp = (NodeInt) current.getLeft();
                current.setLeft(current.getRight().getRight());
                return true;
            } else {
                return delete(goal, (NodeInt) current.getRight());
            }
        }
        if ( tmp != null ){
            addNode(tmp);
        }
        return false;
    }
}
