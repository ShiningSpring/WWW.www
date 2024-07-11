import Robot
characters = [
    (101, "ドラえもん", "猫型ロボット"),
    (202, "のび太", "人間"),
    (303, "しずか", "人間")
]


robot = Robot.Robot(2, "R2-D2", "Astromech")
print(robot.id)
print(robot.name)
print(robot.type)

robot.id = 1
robot.name = "ドラえもん"
robot.type = "ネコ"

print(robot.id)
print(robot.name)
print(robot.type)

robot.hello()
robot.give_dorayaki(9)
print(robot.help())


robots = list(map(lambda x: Robot.Robot(*x), characters))
print(robots)
for i in robots:
    i.hello()
    print(i.id)