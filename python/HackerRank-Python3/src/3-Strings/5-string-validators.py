# https://www.hackerrank.com/challenges/string-validators

if __name__ == '__main__':
    inputString = input()
    print(any(ch.isalnum() for ch in inputString))
    print(any(ch.isalpha() for ch in inputString))
    print(any(ch.isdigit() for ch in inputString))
    print(any(ch.islower() for ch in inputString))
    print(any(ch.isupper() for ch in inputString))
