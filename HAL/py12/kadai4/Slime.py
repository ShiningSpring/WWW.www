import random as R

class Slime ():
    def __init__(self) :
        self.__position = 0
        self.__mk = '='
        self.__hd = '〇'

    @property
    def position(self):
        return self.__position
    
    @position.setter
    def position(self,x):
        self.__position = x

    @property
    def mk(self):
        return self.__mk
    
    @mk.setter
    def mk(self,x):
        self.__mk = x

    @property
    def hd(self):
        return self.__hd
    
    @hd.setter
    def hd(self,x):
        self.__hd = x

    def run(self):
        self.position += R.randint(-1,3)
        return print(self.mk*(self.position)+self.hd)
    
        