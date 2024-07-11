import tkinter as tk
import pickle as pk

with open('config.binaryfile' , 'rb') as web:
    oll=pk.load(web)

current_number = 0
# 第一項
first_term = 0
# 第二項
second_term = 0

tp = 0
# 結果
result = 0
def do():
    "+ キーが押されたときの計算動作, 第一項の設定と入力中の数字のクリア"
    global current_number
    global first_term
    if first_term == 0:

        first_term = current_number
        current_number = 0

def do_eq():
    "= キーが押されたときの計算動作, 第二項の設定、加算の実施、入力中の数字のクリア"
    global first_term
    global second_term
    global third_term
    global result
    global current_number
    second_term = current_number
    if second_term == 0:
        pass
    elif tp == 1:
        result = first_term + second_term

    elif tp == 2:
        result = first_term - second_term

    elif tp == 3:
        result = first_term * second_term

    elif tp == 4:
        result = first_term / second_term

    current_number = 0
    first_term = result





# 数字キーの Call Back 関数
def key1():
    key(1)
def key2():
    key(2)
def key3():
    key(3)
def key4():
    key(4)
def key5():
    key(5)
def key6():
    key(6)
def key7():
    key(7)
def key8():
    key(8)
def key9():
    key(9)
def key0():
    key(0)






def key(n):
    global current_number
    current_number = current_number * 10 + n
    show_number(current_number)
def clear():
    global current_number
    current_number = 0
    global first_term
    first_term = 0
    show_number(current_number)
def plus():
    global tp
    do()
    show_number(current_number)
    tp = 1
def minus():
    global tp
    do()
    show_number(current_number)
    tp = 2
def aaa():
    global tp
    do()
    show_number(current_number)
    tp = 3
def bbb():
    global tp
    do()
    show_number(current_number)
    tp = 4

def stop():
    root.destroy()

def eq():
    do_eq()
    show_number(result)
def show_number(num):
    e.delete(0,tk.END)
    e.insert(0,str(num))

# tkinter での画面の構成
root = tk.Tk()
f = tk.Frame(root,bg = '#c3c3c3')
f.grid()









# ウィジェットの作成
b1 = tk.Button(f,text='1',command=key1,bg='#ffffff',width=2,font=('Helvetica', 14))
b2 = tk.Button(f,text='2', command=key2,bg='#ffffff',width=2,font=('Helvetica', 14))
b3 = tk.Button(f,text='3', command=key3,bg='#ffffff',width=2,font=('Helvetica', 14))
b4 = tk.Button(f,text='4', command=key4,bg='#ffffff',width=2,font=('Helvetica', 14))
b5 = tk.Button(f,text='5', command=key5,bg='#ffffff',width=2,font=('Helvetica', 14))
b6 = tk.Button(f,text='6', command=key6,bg='#ffffff',width=2,font=('Helvetica', 14))
b7 = tk.Button(f,text='7', command=key7,bg='#ffffff',width=2,font=('Helvetica', 14))
b8 = tk.Button(f,text='8', command=key8,bg='#ffffff',width=2,font=('Helvetica', 14))
b9 = tk.Button(f,text='9', command=key9,bg='#ffffff',width=2,font=('Helvetica', 14))
b0 = tk.Button(f,text='0', command=key0,bg='#ffffff',width=2,font=('Helvetica', 14))
bc = tk.Button(f,text='C', command=clear,bg='#ffffff',width=2,font=('Helvetica', 14))
bp = tk.Button(f,text='+', command=plus,bg='#ffffff',width=2,font=('Helvetica', 14))
be = tk.Button(f,text="=", command= eq,bg='#ffffff',width=2,font=('Helvetica', 14))
bb = tk.Button(f,text='-', command=minus,bg='#ffffff',width=2,font=('Helvetica', 14))
br = tk.Button(f,text='*', command=aaa,bg='#ffffff',width=2,font=('Helvetica', 14))
bd = tk.Button(f,text='/', command=bbb,bg='#ffffff',width=2,font=('Helvetica', 14))
bt = tk.Button(f,text='ESC',command=stop,bg='#a1a1a1',width=3,font=('Helvetica', 10))


# Grid 型ジオメトリマネージャによるウィジェットの
# 割付
b1.grid(row=3,column=0)
b2.grid(row=3,column=1)
b3.grid(row=3,column=2)
b4.grid(row=2,column=0)
b5.grid(row=2,column=1)
b6.grid(row=2,column=2)
b7.grid(row=1,column=0)
b8.grid(row=1,column=1)
b9.grid(row=1,column=2)
b0.grid(row=4,column=0)
bc.grid(row=1,column=3)
be.grid(row=5,column=2)
bp.grid(row=2,column=3)
bb.grid(row=3,column=3)
br.grid(row=4,column=3)
bd.grid(row=5,column=3)
bt.grid(row=5,column=0)






with open('config.binaryfile', 'wb') as web:
    pk.dump(oll, web)
# 数値を表示するウィジェット
e = tk.Entry(f,font=('Helvetica', 14))
e.grid(row=0,column=0,columnspan=4)
clear()
# ここから GUI がスタート
root.mainloop()







































