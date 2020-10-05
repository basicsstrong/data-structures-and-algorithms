class HuffmanNode:
    def __init__(self, freq, data, left, right):
        self.freq = freq;
        self.data = data;
        self.left = left;
        self.right = right;

global charBinaryMapping, str
charBinaryMapping = {}
str = 'ABBCCCCGGGGDEAAAEDBBBDFAGG'


def generate_tree(mapping):

    keySet = mapping.keys()
    priorityQ = []

    for c in keySet:
        node = HuffmanNode(mapping[c], c, None, None)
        priorityQ.append(node)
        priorityQ = sorted(priorityQ, key=lambda x: x.freq)

    while len(priorityQ) > 1 :
        first = priorityQ.pop(0);
        second = priorityQ.pop(0);
        merge_node = HuffmanNode(first.freq + second.freq, '-', first, second)
        priorityQ.append(merge_node)
        priorityQ = sorted(priorityQ, key=lambda x: x.freq)

    return priorityQ.pop();


def set_binary_code(node, str):
    if not node is None:
        if node.left is None and node.right is None:
            charBinaryMapping[node.data] = str

        str += '0'
        set_binary_code(node.left, str)
        str = str[:-1]

        str += '1'
        set_binary_code(node.right, str)
        str = str[:-1]


def encode(str):
    mapping = {}
    for c in str:
        if not c in mapping:
            mapping[c] = 1
        else:
            mapping[c] += 1

    print(mapping)
    root = generate_tree(mapping)

    set_binary_code(root, '')

    print(' Char | Huffman code ')
    print('----------------------')
    for char in mapping:
        print(' %-4r |%12s' % (char, charBinaryMapping[char]))

    s = ''
    for c in str:
        s += charBinaryMapping[c]
    return s


code = encode(str)
print(code)
