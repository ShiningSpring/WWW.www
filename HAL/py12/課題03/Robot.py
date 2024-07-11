import random as R
class Robot:
    def __init__(self, id, name, type):
        self.__id = id
        self.__name = name
        self.__type = type
        self.__secret_items = ("どこでもドア", "タケコプター", "タイムふろしき", "スモールライト", "ほんやくコンニャク")

    @property
    def id(self):
        return self.__id

    @id.setter
    def id(self, x):
        self.__id = x

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, x):
        self.__name = x

    @property
    def type(self):
        return self.__type

    @type.setter
    def type(self, x):
        self.__type = x

    @property
    def secret_items(self):
        return self.__secret_items
    
    

    def hello(self):
        print(f'こんいちは！{self.name}です！')

    def give_dorayaki(self, val):
        if val <= 0:
            print('WWWWWW!')
        elif val <= 4:
            print('XXXXXX!')
        elif val <= 9:
            print('YYYYY!')
        else:
            print('ZZZZZ!')

    def help (self):
        return R.choice(self.secret_items)