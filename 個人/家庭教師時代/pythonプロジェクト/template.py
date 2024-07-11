# -*- coding: utf-8 -*-
"""
Created on %(date)s

@author: %(username)s
"""


# class MyClass():
#     a = "マイクラス"

#     __b = 0


#     def __init__(self, data):
#         self.__number = MyClass.__b
#         self.mydata = data
#         print("MyClass Object is created, number:",
#               self.__number)
#         MyClass.__b += 1


#     def show_number(self):
#         print(self.__number)





# if __name__ == "__main__":
#     print("MyClass のクラス変数 a:",MyClass.a)



#     instance1 = MyClass(1)
#     instance2 = MyClass(10)
#     instance1.show_number()
#     instance2.show_number()


#     print("mydata of instance1:",instance1.mydata)
#     print("mydata of instance2:",instance2.mydata)

#     instance1.mydata += 1
#     instance2.mydata += 2

#     print("mydata of instance1: ", instance1.mydata)
#     print("mydata of instance2: ", instance2.mydata)






class 人():
    def __init__(self,体力補正,知力補正,攻撃力補正):
        self.__体力 = 100 + 体力補正
        self.__知力 = 100 + 知力補正
        self.__攻撃力 = 20 + 攻撃力補正

    def ステータス確認(self):
        print("体力",self.__体力,"知力",self.__知力,"攻撃力",self.__攻撃力)

    def つまずいた(self):
        self.__体力 -= 10E6
        print("つまずいたためダメージを受ける")






if __name__ == "__main__":
    村人 = 人(0,0,0)
    村人.ステータス確認()
    村人.つまずいた()
    村人.ステータス確認()



    超野菜人 = 人(500,-300,800)
    超野菜人.ステータス確認()































































