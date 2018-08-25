# https://www.hackerrank.com/challenges/alphabet-rangoli/


def print_rangoli(size):
    import string
    alpha = string.ascii_lowercase
    line = []
    for j in range(size):
        s = "-".join(alpha[j:size])
        line.append((s[::-1] + s[1:]).center(4 * size - 3, "-"))
    print("\n".join(line[:0:-1] + line))


if __name__ == '__main__':
    i = int(input("Enter the size of the alphabet rangoli: "))
    print_rangoli(i)
