# https://www.hackerrank.com/challenges/python-lists


if __name__ == '__main__':
    list = []
    n = int(input())
    for i in range(0, n):
        user_input = input().split(' ')
        command = user_input[0]
        args = user_input[1:]
        if command == 'insert':
            list.insert(int(args[0]), int(args[1]))
        elif command == 'print':
            print(list)
        elif command == 'remove':
            list.remove(int(args[0]))
        elif command == 'append':
            list.append(int(args[0]))
        elif command == 'sort':
            list.sort()
        elif command == 'pop':
            list.pop()
        elif command == 'reverse':
            list.reverse()
