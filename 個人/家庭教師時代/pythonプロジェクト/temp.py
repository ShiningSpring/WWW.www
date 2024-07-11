# def FizzBazz(x, y, s, e):
    
#     for i in range(s, e+1):


#         if (i%(x*y)==0 ):
#             print ('Fizz!Bazz!')
#         elif (i%x == 0):
#             print ('Fizz!')
#         elif (i%y == 0):
#             print('Bazz!')
#         else:
#             print(i)

    


# FizzBazz(10, 2, 1, 100 )

# while True:
#     x = int(input())
#     if x>2021:
#         print("未対応")
#     elif 2022>x>=2019:
    
#         if x==2019:
#             print("令和元年")
    
        
#         else: 
#             print("令和", x - 2018, "年")
    
#     elif x>=1989:
#         if x==1989:
#             print("平成元年")
        
#         else:
#             print("平成", x - 1988, "年")
    
#     elif x>=1926:
#         if x==1926:
#             print("昭和元年’")
        
#         else:
#            print("昭和", x-1925, "年")
#     else:
#         print("未対応")





# def square_ruut(x):

#     rnew = x
 

#     diff = rnew - x/rnew

#     if (diff < 0):
#             diff = -diff
     
     
#     while (diff > 1.0E-6):
#              r1 = rnew
#              r2 = x/r1
#              rnew = (r1 + r2)/2
#              print(r1, rnew, r2)     
#              diff = r1 - r2
         
#              if (diff < 0):
#                  diff = -diff
#     return rnew
        
# v = 2

# r = square_ruut(v)

# print("結果は", r)


# a = [5, 1, 3, 4]

# a.append(5)



# sum = 0
# for i in a:
#     sum += i

# ave = sum/len(a)

# print(ave)







class Dentaku():
    def __init__(self):
        self.first_term = 0
        self.second_term = 0
        self.result = 0
        self.operation = "+"

    def do_operation(self):
        if self.operation == "+":
            self.result = self.first_term + self.second_term
            
        elif self.operation == "-":
            self.result = self.first_term - self.second_term
            
        elif self.operation == "*":
            self.result = self.first_term * self.second_term
            
        elif self.operation == "/":
            self.result = self.first_term / self.second_term    
        else :
            print("非対応")


dentaku1 = Dentaku()
dentaku2 = Dentaku()
dentaku3 = Dentaku()
while True:
    
    dentaku1.first_term = int(input("First term"))
    
    dentaku1.operation = input("Operation")
    
    dentaku1.second_term = int(input("Secont term"))
    
    dentaku1.do_operation()
    
    
    dentaku2.first_term = int(input("Third term"))
    
    dentaku2.operation = input("Operation")
    
    dentaku2.second_term = int(input("Fourth term"))
    
    dentaku2.do_operation()
    
    
    dentaku3.first_term = dentaku1.result
    
    dentaku3.operation = input("Operation")
    
    dentaku3.second_term = dentaku2.result
    
    dentaku3.do_operation()
    
    
    
    print("Result",dentaku3.result)




















































