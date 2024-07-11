import re

#ex1
print(re.search(r'xyz','xyz'))

#ex2
print(re.search(r'(xyz|XYZ)','XYZ'))

#ex3
print(re.search(r'^xyz','xyz'))

#ex4
print(re.search(r'xyz$','xyz'))

#ex5
print(re.search(r'^xyz$','xyz'))

#ex6
print(re.search(r'x.z','xpz'))

#ex7
print(re.search(r'.xyz.','1xyz1'))

#ex8
print(re.search(r'x{5}yz','xxxxxyz'))

#ex9
print(re.search(r'x{5,8}yz','xxxxxxyz'))

#ex10
print(re.search(r'xy[x-z]','xyx'))

#ex11
print(re.search(r'[a-z]','h'))

#ex12
print(re.search(r'[a-zA-Z0-9]{3}','gG5'))

#ex13
print(re.search(r'\d{3}','１58'))

#ex14
print(re.search(r'\bpython\b','python'))

#ex15
print(re.search(r'(Red|Green|Blue){3}','RedRedRed'))

#ex16
print(re.search(r'国(?=営|民)','国営'))

#ex17
print(re.search(r'(?<=ラー|ソー)メン','ソーメン'))

#ex18
print(re.search(r'\.(jpg|png|gif|webp)$','.jpg.png'))

#ex19
print(re.search(r'[A-Z]{2}-[0-9]{2}[A-B]-[0-9]{3}$','IH-12B-111'))

#ex20
print(re.search(r'^[ton][hmi]s[0-9]{5}$','ths00000'))
ex1 = r'xyz'
ex2 = r'xyz|XYZ'
ex3 = r'^xyz'
ex4 = r'xyz$'
ex5 = r'^xyz$'
ex6 = r'x.z'
ex7 = r'.xyz.'
ex8 = r'x{5}yz'
ex9 = r'x{5,8}yz'
ex10 = r'^xy[x-z]'
ex11 = r'[a-z]'
ex12 = r'[a-zA-Z0-9]{3}'
ex13 = r'\d{3}'
ex14 = r'\bpython\b'
ex15 = r'(Red|Green|Blue){3}'
ex16 = r'国(?=営|民)'
ex17 = r'(?<=ラー|ソー)メン'
ex18 = r'\.(jpg|png|gif|webp)$'
ex19 = r'^[A-Z]{2}-[0-9]{2}[A-B]-[0-9]{3}$'
ex20 = r'^[ton][hmi]s[0-9]{5}$'