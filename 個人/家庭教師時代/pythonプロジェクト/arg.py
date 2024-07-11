

#100
a = [52, 11, 31, 88, 16, 82, 94, 27, 83, 77, 60, 96, 84, 67, 68, 7, 25, 2, 19, 64, 91, 95, 72, 92, 26, 20, 39, 99, 22, 98, 59, 41, 48, 69, 87, 70, 62, 66, 85, 28, 71, 51, 35, 32, 73, 10, 5, 50, 30, 45, 79, 55, 93, 13, 89, 75, 17, 12, 53, 44, 4, 86, 49, 24, 54, 9, 78, 56, 6, 80, 42, 3, 33, 74, 76, 47, 15, 8, 38, 14, 1, 100, 36, 81, 23, 34, 90, 65, 43, 21, 37, 63, 40, 46, 61, 57, 29, 97, 58, 18]





# flag = False



# while True:



#     flag = False


#     for i in range(99):
#         if a[i]>a[i+1]:

#             flag = True
#             a[i],a[i+1] = a[i+1],a[i]



#     if flag == False:
#         break


#     print(a)






# a = sample(range(1,101),k=100)





# print(a)




def ggg(a):
    f = len(a)
    for i in range(1,f):
        tmp = a[i]
        if tmp < a[i-1]:
            u = i
            while True:
                a[u] = a[u-1]
                u -= 1
                if u == 0 or tmp >= a[u-1]:
                    break
            a[u] = tmp

ggg(a)
print(a)







# def sort(lst):
#     n = len(a)
#     for i in range(n):
#         for j in reversed(range(i)):
#             if a[j] > a[j+1]:
#                 a[j], a[j+1] = a[j+1], a[j]
#             else:
#                 break


# sort(a)
# print(a)

















































