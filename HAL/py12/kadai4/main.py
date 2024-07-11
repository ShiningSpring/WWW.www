import Slime as S
x = True

Slimes = [S.Slime() for _ in range(3) ]
print(Slimes)
while x:
    print('――――5――――10')
    for i in Slimes:
        i.run()
        if i.position >=10:
            x = False

    

