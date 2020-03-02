package Tree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if(root == null){
            root = creatNewNode(e);
        } else {
            TreeNode<E> parent  = null;
            TreeNode<E> current  = root;
            while (current != null){
                if(e.compareTo(current.element) < 0){
                    parent = current;
                    current  = current.left;
                } else if(e.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if(e.compareTo(parent.element) < 0){
                parent.left = creatNewNode(e);
            } else
                parent.right = creatNewNode(e);
        }
        size++;
        return true;
    }

    protected TreeNode<E> creatNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }
    protected void postorder(TreeNode<E> root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root){
        if(root == null) return;
        System.out.print(root.element + " ");
        postorder(root.left);
        postorder(root.right);
    }

    public void delete(E e) {
        root = deleteRec(root,e);
    }

    private TreeNode<E> deleteRec(TreeNode<E> root,E e){
        if(root == null)
            return root;
        if(e.compareTo(root.element) < 0){
            root.left = deleteRec(root.left,e);
        }
        else if(e.compareTo(root.element) > 0){
            root.right = deleteRec(root.right,e);
        }
        else
        {
            if(root.left == null){
                return deleteRec(root.right, e);
            } else if(root.right == null){
                return deleteRec(root.left, e);
            }

            root.element = minValue(root.right);
            root.right = deleteRec(root.right,root.element);
        }
        return root;
    }

    public E minValue(TreeNode<E> root){
        E minv = root.element;
        while(root.left != null){
            minv = root.left.element;
            root = root.left;
        }
        return minv;
    }

    public boolean search(E e){
        TreeNode<E> parentNode;
        TreeNode<E> currentNode = root;

        if (currentNode == null) {
            return false;
        }
        while (currentNode != null) {
            if (e.compareTo(currentNode.element) < 0) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (e.compareTo(currentNode.element) > 0) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else if (e.compareTo(currentNode.element) == 0) {
                break;
            }
        }

        if(currentNode.element.equals(e)){
            return true;
        } else
            return false;
    }
}
