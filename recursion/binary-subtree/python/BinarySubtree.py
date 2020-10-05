
class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def is_subtree(tree, subtree):

    if subtree is None:
        return True
    if tree is None:
        return False

    tree1 = []
    tree2 = []

    in_order(tree, tree1)
    in_order(subtree, tree2)

    str1 = tree1.__str__().replace("[", "").replace("]", "")
    str2 = tree2.__str__().replace("[", "").replace("]", "")

    if str1.find(str2) == -1:
        return False

    tree1 = []
    tree2 = []

    pre_order(tree, tree1)
    pre_order(subtree, tree2)

    str3 = tree1.__str__().replace("[", "").replace("]", "")
    str4 = tree2.__str__().replace("[", "").replace("]", "")

    if str3.find(str4) == -1:
        return False
    return True


def in_order(tree, tree1):

    if tree is None:
        return

    in_order(tree.left, tree1)
    tree1.append(tree.data)
    in_order(tree.right, tree1)


def pre_order(tree, tree1):

    if tree is None:
        return

    tree1.append(tree.data)
    pre_order(tree.left, tree1)
    pre_order(tree.right, tree1)


root1 = Node(1);
root1.left = Node(2);
root1.right = Node(3);
root1.left.left = Node(4);
root1.left.right = Node(5);
root1.right.left = Node(6);
root1.right.right = Node(7);

root2 = Node(3)
root2.left = Node(6);
root2.right = Node(7);


is_subtree = is_subtree(root1, root2)
print(is_subtree)

