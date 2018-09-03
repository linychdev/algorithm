package classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 骑士游历(Knight tour)在十八世纪初备受数学家与拼图迷的注意，究竟它是什么时候被提出已不可考。
 * 骑士的走法为国际象棋的走法，类似中国象棋的马，骑士可以由任意一个位置出发，他如何走完所有的位置？
 * 
 * 思路:问题解法：
 * 骑士的走法，基本上可以用递归的方法来解决，但是纯粹的递归在维度大时相当没有效率。
 * 一个聪明的解法由J.C.Warnsdorff在1823年提出，简单的说，先将最难的位置走完，接下来的路就是宽广，骑士所要走的下一步：
 * 为下一步再做选择时，所能走的步数最少的一步。使用这个方法，在不使用递归的情况下，可以有较高的几率找出走法(有时可能也找不到走法)。
 *
 * 本实现为面向对象思路，创建一个骑士类，骑士类有自己的位置属性和下一步的可能位置集合，在创建对象时就初始化好。主程序中只要依次获取当前位置的下一个位置即可
 * KnightTour
 * @author linych
 * @version 1.0
 *
 */
public class KnightTour {
    List<Direction> dirs = new ArrayList<Direction>();
    public KnightTour(){
      super();
      //初始化8个可走方向
      int[] ktmoveX = {1,  2,  2, 1, -1, -2, -2, -1};
      int[] ktmoveY = {-2, -1, 1, 2,  2,  1, -1, -2};
        for (int i = 0; i < ktmoveX.length; i++) {
            Direction d = new Direction(ktmoveX[i], ktmoveY[i]);
            dirs.add(d);
        }
    }
    
    static final int CHECKERBOARDSIZE = 10;
    
    //初始化一个8*8的空棋盘
    static int[][] checkerboard = new int[CHECKERBOARDSIZE][CHECKERBOARDSIZE];
    
    //骑士对象，有当前位置，下一步位置，下一步可走位置属性
    class Knight{
        Direction dir;
        List<Direction> nextDirs = new ArrayList<Direction>();
        
        public Knight(){
            super();
        }
        public Knight(Direction dir){
            super();
            this.dir = dir;
            init();
        }
        
        //初始化，碰到边缘不能走，已经走过的不能走
        private void init(){
            for (Direction d : dirs) {
                int tempX = dir.getX() + d.getX(); 
                int tempY = dir.getY() + d.getY(); 
                if(tempX<0 || tempY<0 || tempX>CHECKERBOARDSIZE - 1 || tempY>CHECKERBOARDSIZE - 1){
                    continue;
                }
                if(checkerboard[tempY][tempX] == 0){
                    nextDirs.add(new Direction(tempX, tempY));
                }
            }
        }
        
        public Direction getDir() {
            return dir;
        }
        public void setDir(Direction dir) {
            this.dir = dir;
        }
        public List<Direction> getNextDirs() {
            return nextDirs;
        }
        public void setNextDirs(List<Direction> nextDirs) {
            this.nextDirs = nextDirs;
        }
    }
    
    
    public static void main(String[] args) {
        //初始化一个64大小的数组，初始元素全部为null
        Direction[] checkerboardArray = new Direction[CHECKERBOARDSIZE*CHECKERBOARDSIZE];
        List<Direction> checkerboardList = Arrays.asList(checkerboardArray);
        //指定一个出发点
        int x = 1;
        int y = 3;
        Direction dir = new Direction(x, y);
        checkerboard[y][x] = 1;
        checkerboardList.set(0,dir);
        KnightTour kt = new KnightTour();
        //从起始位置开始，逐个获取下一个位置
        for (int i = 0; i < CHECKERBOARDSIZE*CHECKERBOARDSIZE; i++) {
            Direction d = checkerboardList.get(i);
            Direction next = getNext(kt, d);
            //如果存在下一步，在棋盘上标注，并打印
            if(next != null){
                checkerboardList.set(i+1, next);
                checkerboard[next.getY()][next.getX()] = i+2;
                System.out.println(next);
                printCheckerBoard();
            }
        }
        
    }


    private static Direction getNext(KnightTour kt, Direction dir) {
        Knight k = kt.new Knight(dir);
        List<Direction> nextDirs = k.getNextDirs();
        int min = Integer.MAX_VALUE;
        for (Direction nextd : nextDirs) {
            Knight nextk = kt.new Knight(nextd);
            if(nextk.getNextDirs().size()<min){
                min = nextk.getNextDirs().size();
            }
        }
        
        for (Direction nextd : nextDirs) {
            Knight nextk = kt.new Knight(nextd);
            if(nextk.getNextDirs().size()==min){
                return nextd;
            }
        }
        return null;
    }


    private static void printCheckerBoard() {
        for (int i = 0; i < CHECKERBOARDSIZE; i++) {
            for (int j = 0; j < CHECKERBOARDSIZE; j++) {
                System.out.print(checkerboard[i][j]);
                if(j < CHECKERBOARDSIZE - 1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
    
}

class Direction{
    int x;
    int y;
    public Direction(int x, int y){
        super();
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int next() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return "Direction [x=" + x + ", y=" + y + "]";
    }
}

