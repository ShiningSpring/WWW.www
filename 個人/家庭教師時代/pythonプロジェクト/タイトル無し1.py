import tkinter as tk
import pickle as pk

with open('config.binaryfile' , 'rb') as web:
    oll=pk.load(web)
root = tk.Tk()
f = tk.Frame(root,bg = '#c3c3c3')
f.grid()


a = 0
b = 0
config = 0






def keisan():
    pass


























with open('config.binaryfile', 'wb') as oll:
    pk.dump(config , oll)




# root.mainloop()

































