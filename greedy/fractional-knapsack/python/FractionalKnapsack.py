

def get_max_value(wt, val, capacity):
    items = [0]* len(wt)

    for i in range(0, len(wt)):
        items[i] = Item(wt[i], val[i], i)

    items.sort(reverse= True)

    total_val = 0
    for item in items:
        cur_wt = int(item.wt)
        cur_val = int(item.val)

        if capacity - cur_wt >= 0:
            capacity = capacity - cur_wt
            total_val += cur_val
        else:
            fraction = capacity / cur_wt
            total_val += cur_val * fraction
            # capacity = int(capacity - (cur_wt * fraction))
            break

    return total_val


class Item:
    def __init__(self, wt, val, ind):
        self.wt = wt
        self.val = val
        self.ind = ind
        self.cost = val//wt

    def __lt__(self, other):
        return self.cost < other.cost

wt = [10, 40, 20, 30]
val = [60, 40, 100, 120]
capacity = 50

max_val = get_max_value(wt, val, capacity)
print('The maximum profit possible = ', max_val)


