# https://www.hackerrank.com/challenges/find-a-string


def count_substring(string, sub_string):
    count = 0
    l_sub = len(sub_string)
    for i in range(len(string) - l_sub + 1):
        if string[i:i + l_sub] == sub_string:
            count = count + 1
    return count


if __name__ == '__main__':
    string = input().strip()
    substring = input().strip()
    count = count_substring(string, substring)
    print(count)
