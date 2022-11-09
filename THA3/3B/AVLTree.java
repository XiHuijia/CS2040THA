//XI Huijia, A0220056W
import java.util.*;
class AVLTree {
    AVLNode root;
    
    AVLTree() {
        root = null;
    }
    
    int height(AVLNode node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    int height() {
        return height(root);
    }

    int max(int a, int b) {
        return a>b ?a:b;
    }

    AVLNode leftleftRotation(AVLNode node) {
        AVLNode temp = node.left;
        node.left = temp.right;
        temp.right = node;

        node.height = max(height(node.left), height(node.right)) + 1;
        temp.height = max(height(temp.left), node.height) + 1;
        node.size = size(node.left) + size(node.right) + 1;
        temp.size = size(temp.left) + size(temp.right) + 1;

        return temp;
    }

    AVLNode rightrightRotation(AVLNode node) {
        AVLNode temp = node.right;
        node.right = temp.left;
        temp.left = node;

        node.height = max(height(node.left), height(node.right)) + 1;
        temp.height = max(height(temp.right), node.height) + 1;
        node.size = size(node.left) + size(node.right) + 1;
        temp.size = size(temp.left) + size(temp.right) + 1;

        return temp;
    }

    AVLNode leftrightRotation(AVLNode node) {
        node.left = rightrightRotation(node.left);

        return leftleftRotation(node);
    }

    AVLNode rightleftRotation(AVLNode node) {
        node.right = leftleftRotation(node.right);

        return rightrightRotation(node);
    }

    AVLNode insert(AVLNode node, Team key) {
        if (node == null) {
            node = new AVLNode(key, null, null);
            if (node == null) {
                return null;
            }
        } else {
            int compare = key.compareTo(node.key);

            if (compare < 0) {
                node.left = insert(node.left, key);
                if (height(node.left) - height(node.right) == 2) {
                    if (key.compareTo(node.left.key) < 0) {
                        node = leftleftRotation(node);
                    } else {
                        node = leftrightRotation(node);
                    }
                }
            } else if (compare > 0) {
                node.right = insert(node.right, key);
                if(height(node.right) - height(node.left) == 2) {
                    if (key.compareTo(node.right.key) > 0) {
                        node = rightrightRotation(node);
                    } else {
                        node = rightleftRotation(node);
                    }
                }
            } 
        }

        node.height = max(height(node.left), height(node.right)) + 1;
        node.size = size(node.left) + size(node.right) + 1;
        
        return node;
    }

    void insert(Team key) {
        root = insert(root, key);
    }

    AVLNode remove(AVLNode node, AVLNode another) {
        if (node == null || another == null) {
            return null;
        }

        int compare = another.key.compareTo(node.key);
        if (compare < 0) {
            node.left = remove(node.left, another);
            if (height(node.right) - height(node.left) == 2) {
                AVLNode rNode = node.right;
                if (height(rNode.left) > height(rNode.right)) {
                    node = rightleftRotation(node);
                } else {
                    node = rightrightRotation(node);
                }
            } 
        } else if (compare > 0) {
            node.right = remove(node.right, another);
            if (height(node.left) - height(node.right) == 2) {
                AVLNode lNode = node.left;
                if (height(lNode.right) > height(lNode.left)) {
                    node = leftrightRotation(node);
                } else {
                    node = leftleftRotation(node);
                }
            }
        } else {
            if (node.left != null && node.right != null) {
                if (height(node.left) > height(node.right)) {
                    AVLNode max = maximum(node.left);
                    node.key = max.key;
                    node.left = remove(node.left, max);
                } else {
                    AVLNode min = minimum(node.right);
                    node.key = min.key;
                    node.right = remove(node.right, min);
                }
            } else {
                AVLNode temp = node;
                node = (node.left != null) ? node.left: node.right;
                temp = null;
            }
        }

        if (node != null) {
            node.size = size(node.left) + size(node.right) + 1;
        }
        
        
        return node;
    }

    void remove(Team key) {
        AVLNode node;
        if ( (node = search(root, key)) !=null) {
            root = remove(root, node);
        }
    }

    AVLNode search(AVLNode node, Team key) {
        if (node == null) {
            return node;
        }

        int compare = key.compareTo(node.key);
        if (compare<0) {
            return search(node.left, key);
        } else if (compare>0) {
            return search(node.right, key);
        } else {
            return node;
        }
    }

    AVLNode search(Team key) {
        return search(root, key);
    }

    AVLNode minimum(AVLNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    AVLNode maximum(AVLNode node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    Team minimum() {
        AVLNode node = minimum(root);
        if (node != null) {
            return node.key;
        }
        return null;
    }


    Team maximum() {
        AVLNode node = maximum(root);
        if (node != null) {
            return node.key;
        }
        return null;
    }

    int size(AVLNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    int rank(AVLNode node, Team key) {
        while(node != null) {
            int compare = key.compareTo(node.key);
            if (compare==0) {
                if(node.left != null) {
                    return node.left.size + 1;
                } else {
                    return 1;
                }
                
            } else if (compare<0) {
                return rank(node.left, key);
            } else {
                if(node.left != null) {
                    return node.left.size + 1 + rank(node.right, key);
                } else {
                    return 1 + rank(node.right, key);
                }                
            }
        }
        return 0;
    }

    int rank(Team key) {
        return rank(root, key);
    }
}
