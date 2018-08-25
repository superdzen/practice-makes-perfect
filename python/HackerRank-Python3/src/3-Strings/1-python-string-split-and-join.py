# https://www.hackerrank.com/challenges/python-string-split-and-join


def split_and_join(l):
    a = l.strip().split(" ")
    r = "-".join(a)
    return r


if __name__ == '__main__':
    line = input()
    result = split_and_join(line)
    print(result)
