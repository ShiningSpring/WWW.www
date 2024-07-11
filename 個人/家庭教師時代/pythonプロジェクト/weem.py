from turtle import *


# n=17



# for i in range(n):
#     forward(50)
#     left(360/n)

# for i in range(5):
#     forward(50)
#     left(144)
    


# t1 = Turtle()
# t2 = Turtle()
# t1.color('magenta')
# t2.color('green')


# for i in range(180):
#   t1.forward(5)
#   t2.forward(3)
#   t1.left(2)
#   t2.left(2)
# done()




# def come(x,y):
#     (xx,yy) = pos()
#     newxy = ((xx+x)/2,(yy+y)/2)
#     print(x,y)
#     goto(newxy)
    
# onscreenclick(come)

# done()

speed(10)
# def detour(L):
#     if (L < 10):
#         forward(L)
#     else:
#         LL = L/3
#         detour(LL)
#         left(60)
#         detour(LL)
#         right(120)
#         detour(LL)
#         left(60)
#         detour(LL)





# for i in range(6):
#     detour(100)
#     left(60)






def tree(n, angle=10, length=10, skew=0, r_ratio=1, l_ratio=1):
    if n < 0:
        return
    fd(length)
    rt(angle+skew)
    tree(n-1, angle, length * r_ratio)
    lt(angle * 2)
    tree(n-1, angle, length * l_ratio)
    rt(angle-skew)
    bk(length)

if __name__ == '__main__':
        lt(90)
        pu()
        bk(100)
        pd()
        speed(10)
        tree(10, 35, skew=50)
        done()
        
        
        
tree(0)



# while Turtle:
#   print("")





















