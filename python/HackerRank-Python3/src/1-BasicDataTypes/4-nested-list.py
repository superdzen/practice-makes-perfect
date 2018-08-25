# https://www.hackerrank.com/challenges/nested-list/problem


if __name__ == '__main__':
    students_list = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        students_list.append([name, score])
    students_list = sorted(students_list)
    second_lowest_grade = sorted(list(set(grade for [_, grade] in students_list)))[1]
    for student in students_list:
        if student[1] == second_lowest_grade:
            print(student[0])
