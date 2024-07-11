import tkinter as tk
import tkinter.messagebox
import random


OPEN = None
YOU = 1
COM = 2
EVEN = 3



RESULT = ['勝ち','負け','引き分け']



board = [[0,0,0],[0,0,0],[0,0,0]]



log1 = [[0, 0], [1, 1], [1, 0], [2, 0], [0, 2], [0, 1], [2, 1], [2, 2], [1, 2], [EVEN]]
log2 = [[0, 0], [1, 0], [1, 1], [2, 2], [0, 1], [2, 0],[2, 1], [YOU]]
log3 = [[0, 1], [0, 0], [2, 1], [1, 1], [2, 2], [2, 0], [1, 0], [0, 2],[COM]]

CANVAS_SIZE = 400
NUM_SQUARE = 3

BOARD_COLOR = 'gray' # 盤面の背景色
YOUR_COLOR = 'white' # あなたの色
COM_COLOR = 'black' # 相手の色
PLACABLE_COLOR = 'yellow' # 次に石を置ける場所を示す色



class Sanmoku():
    def __init__(self, master):
        self.master = master # 親ウィジェット
        self.player = YOU # 次に置く石の色
        self.board = None # 盤面上の石を管理する２次元リスト
        self.color = { # 石の色を保持する辞書
            YOU : YOUR_COLOR,
            COM : COM_COLOR
        }

        self.createWidgets()
        self.setEvents()
        self.initgame()

    def createWidgets(self):
        self.canvas = tkinter.Canvas(
            self.master,
            bg=BOARD_COLOR,
            width=CANVAS_SIZE+1, # +1は枠線描画のため
            height=CANVAS_SIZE+1, # +1は枠線描画のため
            highlightthickness=0
        )
        self.canvas.pack(padx=10, pady=10)
    def setEvents(self):

        self.canvas.bind('<ButtonPress>', self.click)

    def checkPlacable(self, x, y):
        '''(x,y)に石が置けるかどうかをチェック'''

        # その場所に石が置かれていれば置けない
        if self.board[y][x] == None:
            return True
        return False
    def show_turn(self):
    # '手番を示す文字列を返す'
        if self.player == YOU:
            return('先手')
        elif self.player == COM:
            return('後手')
        else:
            return('手番の値が不適切です')

    def click(self, event):
        if self.player != YOU:
            # COMが石を置くターンの時は何もしない
        
            return
        # クリックされた位置がどのマスであるかを計算
        x = event.x // self.square_size
        y = event.y // self.square_size

        if self.checkPlacable(x, y):
            # 次に石を置けるマスであれば石を置く
            self.place(x, y, self.color[self.player])

    def initgame(self):
        '''ゲームの初期化を行う'''

        # 盤面上の石を管理する２次元リストを作成（最初は全てNone）
        self.board = [[None] * NUM_SQUARE for i in range(NUM_SQUARE)]
        # print(self.board)
        # １マスのサイズ（px）を計算
        self.square_size = CANVAS_SIZE // NUM_SQUARE
        self.log = []
        # マスを描画
        for y in range(NUM_SQUARE):
            for x in range(NUM_SQUARE):
                # 長方形の開始・終了座標を計算
                xs = x * self.square_size
                ys = y * self.square_size
                xe = (x + 1) * self.square_size
                ye = (y + 1) * self.square_size
                
                # 長方形を描画
                tag_name = 'square_' + str(x) + '_' + str(y)
                self.canvas.create_rectangle(
                    xs, ys,
                    xe, ye,
                    tag=tag_name
                )

    def place(self, x, y, color):
        '''(x,y)に色がcolorの石を置く'''



        # (x,y)に石を置く（円を描画する）
        self.drawDisk(x, y, color)

        # 次に石を置くプレイヤーを決める
        self.before_player = self.player
        self.nextPlayer()
        

        # if not self.player:
        #     # 次に石が置けるプレイヤーがいない場合はゲーム終了
        #     self.showResult()
        #     return
        self.log.append([x,y])


        if self.player == COM:
            # 次のプレイヤーがCOMの場合は1秒後にCOMに石を置く場所を決めさせる
            self.master.after(1, self.com)

    def drawDisk(self, x, y, color):
        '''(x,y)に色がcolorの石を置く（円を描画する）'''

        # (x,y)のマスの中心座標を計算
        center_x = (x + 0.5) * self.square_size
        center_y = (y + 0.5) * self.square_size

        # 中心座標から円の開始座標と終了座標を計算
        xs = center_x - (self.square_size * 0.8) // 2
        ys = center_y - (self.square_size * 0.8) // 2
        xe = center_x + (self.square_size * 0.8) // 2
        ye = center_y + (self.square_size * 0.8) // 2
        
        # 円を描画する
        tag_name = 'disk_' + str(x) + '_' + str(y)
        self.canvas.create_oval(
            xs, ys,
            xe, ye,
            fill=color,
            tag=tag_name
        )

        # 描画した円の色を管理リストに記憶させておく
        self.board[y][x] = self.player

    def nextPlayer(self):
        '''次に石を置くプレイヤーを決める'''

        self.placable = self.getPlacable(self.before_player)

        if self.placable == []:
            self.showResult()


        # 石を置くプレイヤーを切り替える
        if self.player == YOU:
            self.player = COM

        else:
            self.player = YOU

        # 切り替え後のプレイヤーが石を置けるかどうかを確認


    def check_board_horizontal(self,t):

        for i in range (3):
            if (self.board[i][0] == t) and (self.board[i][1] == t) and (self.board[i][2] == t):
                return True
        return False

    
    def check_board_vertical(self,t):
    # '垂直方向に手番 t が勝ちであることを判定します'
        for j in range (3):
            if (self.board[0][j] == t) and (self.board[1][j] == t) and (self.board[2][j] == t):
                return True
        return False
    
    
    def check_board_diagonal(self,t):
    # '対角方向に手番 t が勝ちであることを判定します'
        if (self.board[0][0] == t) and (self.board[1][1] == t) and (self.board[2][2] == t):
            return True
        return False
    
    
    def check_board_inverse_diagonal(self,t):
    # '逆対角方向に手番 t が勝ちであることを判定します'
        if (self.board[0][2] == t) and (self.board[1][1] == t) and (self.board[2][0] == t):
            return True
        return False
    
    def is_win_simple(self,t):
    # '手番 t が勝ちであることを判定します。相手が勝っていることはチェックしません'
        if self.check_board_horizontal(t):
            return True
        if self.check_board_vertical(t):
            return True
        if self.check_board_diagonal(t):
            return True
        if self.check_board_inverse_diagonal(t):
            return True
        return False
    
    def is_win_actual(self,t):
    # '手番 t が勝ちであることを判定します。相手が勝っていないことも確認します'

        if not self.is_win_simple(t):
            return False
        if t==YOU:
            if self.is_win_simple(COM):
                return False
        else:
            if self.is_win_simple(YOU):
                return False
        return True
    
    def is_full(self):
    # '盤面に空きがないことを確認します'
        for i in range(3):
            for j in range(3):
                if self.board[i][j] == OPEN:
                    return False
        return True
    
    
    
    def is_even(self):
    # '盤面が引き分けであることを判定します'
        if self.is_win_simple(YOU):
            return False
        if self.is_win_simple(COM):
            return False
        if not self.is_full():
            return False
        return True


    def getPlacable(self, t):

        placable = []


        if (self.is_even()):
            print("引き分けです")
            self.log.append([EVEN])
            return placable
        if (self.is_win_actual(t)):
            print(self.show_turn(), "の勝ちです")
            self.log.append([t])
            return placable

        for y in range(NUM_SQUARE):
            for x in range(NUM_SQUARE):
                # (x,y) の位置のマスに石が置けるかどうかをチェック
                if self.checkPlacable(x, y):
                    # 置けるならその座標をリストに追加
                    placable.append([x, y])



        return placable

    def showResult(self):
        '''ゲーム終了時の結果を表示する'''

        print(self.log)

        # 結果をメッセージボックスで表示する
        tkinter.messagebox.showinfo('結果', RESULT[self.log[-1][0]-1])

    def com(self):
        x,y = self.placable[random.randint(0, len(self.placable)-1)]
        print(x,y)
        self.place(x, y, self.color[self.player])

























































app = tkinter.Tk()
app.title('三目並べ')
sanmoku = Sanmoku(app)
app.mainloop()






































































