class monster ():
    def __init__(self, name, hp, mp):
        self.__name = name
        self.__hp = hp
        self.__mp = mp
        
    def show_status(self):
        print(f"Name: {self.__name}")
        print(f"HP: {self.__hp}")
        print(f"MP: {self.__mp}")

    def cure(self):
        self.__hp += 100

    def get_name(self):
        return self.__name


zombie = monster('zombie', 10, 5)
zombie.show_status()
print()
zombie.cure()
zombie.show_status()
print()
print(zombie.get_name())

class Monster:
                def __init__(self, name, hp, mp):
                                self.__name = name
                                self.__hp = hp
                                self.__mp = mp

                def show_status(self):
                                print(f'Name: {self.__name}')
                                print(f'HP: {self.__hp}')
                                print(f'MP: {self.__mp}')

                def cure(self):
                                self.__hp += 100

                def get_name(self):
                                return self.__name


monster = Monster('Dragon', 300, 150)


monster.show_status()


monster.cure()

monster.show_status()


print(monster.get_name())