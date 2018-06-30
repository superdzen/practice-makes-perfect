# https://www.hackerrank.com/challenges/text-wrap
import textwrap


def wrap(value, max_width):
    lst = textwrap.fill(value, max_width)
    return lst


if __name__ == '__main__':
    string, max_width = input(), int(input())
    result = wrap(string, max_width)
    print(result)
