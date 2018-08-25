# https://www.hackerrank.com/challenges/write-a-function


def is_leap(year):
    leap = False
    if year % 4 == 0:
        if year % 100 == 0:
            if year % 400 == 0:
                leap = True
            else:
                leap = False
        else:
            leap = True
    return leap


if __name__ == '__main__':
    year = int(input())
    print(is_leap(year))
