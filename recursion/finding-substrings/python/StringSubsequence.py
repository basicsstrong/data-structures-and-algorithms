
def get_subsequence(word):

    if len(word) == 0:
        return ''

    first = word[0]
    rest = get_subsequence(word[1:])

    result = ''

    for strsub in rest.split(','):
        result += ',' + first + strsub
        result += ',' + strsub

    result = result[1:]

    return result

print(get_subsequence("XYZ"))