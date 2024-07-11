import re
# 定数
# 対義語は変数。
 
# つまり。
# 　変数＝変動できる箱
# 　定数＝変動できない（定まっている）箱

# JS例
# let a;        <- 変数
# const B = 1;　<- 定数
 
# Pythonには定数の定義手法は無い。
# 変数名を大文字とアンダーバーで定義することにより、
# 定数とみなす慣例が用いられている。
# TAX = 0.1

# 定数として定義された変数は、
# 後から上書きすることができない。というのが一般的な仕様。
# TAX = 0.2   # ←一般的にはエラーになる。けど、Pythonは定数の定義がないため、そうはならない。
 

# 上記３つは全て一緒

# 定数を使うことにより、散在するコードの修正が局所化することができる。
 

# その他の使い方として、数値に意味を持たせることができる。
# この発展形は列挙型。
 
# まずは良くないコード例。
# def print_school(school_type):
#     if school_type == 0:
#         print('HAL')
#     elif school_type == 1:
#         print('MODE')
#     elif school_type == 2:
#         print('IKO')
#     else:
#         print('miss')
 
# print_school(0)
# print_school(1)
# print_school(2)

# 繰り返し指定のメタ文字
# 「直前の文字が」何回繰り返すかを指定することができる。
# + 1回以上
# * 0回以上
# ? 0回か、1回
# {m} m回
# {m,n} m回以上のn回以下
# {m,} m回以上
# {,m} m回以下

# print('+*?{m}{m,n}{m,}')

# 任意文字がbcの手前に3つあればOK

# 文字集合
# [] 何れか
# print()
# ハイフンは、[]の中だと範囲を意味する。
# 外側であれば、通常のabcとかと変わらない。
# print(re.search(r''))

# やってみよう！
# 郵便番号正規表現
# pattern = r'^\d{3}-\d{4}$'
# print("match")
# print(re.search(pattern, '000-0000'))
# print(re.search(pattern, '123-6789'))
 
# print("miss match")
# print(re.search(pattern, ''))
# print(re.search(pattern, '-'))
# print(re.search(pattern, '0000000'))
# print(re.search(pattern, '0-0000'))
# print(re.search(pattern, '00-0000'))
# print(re.search(pattern, '000-0'))
# print(re.search(pattern, '000-00'))
# print(re.search(pattern, '000-000'))
# print(re.search(pattern, ' 000-0000'))
# print(re.search(pattern, '000-0000 '))
# print(re.search(pattern, '000=0000'))
# print(re.search(pattern, 'a00-0000'))
# print(re.search(pattern, '000-000a'))


# match = re.search(r'^\d{4}\d{1,2}\d{1,2}$','2024/5/20')
# match = re.search(r'','２０２４/５/２０')


print(re.search(r'^xyz$','xyz'))






















