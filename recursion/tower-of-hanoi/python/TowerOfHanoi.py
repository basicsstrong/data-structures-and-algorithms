
def tower_of_hanoi(n, from_rod, to_rod, aux_rod):
    if n==1:
        print('Moving the disk 1 from ', from_rod, ' to the ', to_rod, 'rod.')
    else:
        tower_of_hanoi(n-1, from_rod, aux_rod, to_rod)
        print('Moving the disk ',n, 'from ',from_rod,'to the ',to_rod)
        tower_of_hanoi(n-1, aux_rod, to_rod, from_rod)

tower_of_hanoi(4, 'X', 'Y', 'Z')