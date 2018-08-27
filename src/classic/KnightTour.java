package classic;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

public class KnightTour {
//         int i, j, k, l, m;
//         int tmpX, tmpY;
//         int count, min, tmp;
//     
//         //骑士可走的八个方向(顺时针)
//         int[] ktmoveX = {1,  2,  2, 1, -1, -2, -2, -1};
//         int[] ktmoveY = {-2, -1, 1, 2,  2,  1, -1, -2};
//     
//         //下一步坐标
//         int[] nextX = {0};
//         int[] nextY = {0};
//     
//         //记录每个方向的出路的个数
//         int[] exists = {0};
//     
//         //起始用1标记位置
//         i = x;
//         j = y;
//         pos[i][j] = 1;
//     
//         //遍历棋盘
//         for(m=2; m<=64; m++) {
//             //初始化八个方向出口个数
//             for(l=0; l<8; l++) {
//                 exists[l] = 0;
//             }
//             l = 0; //计算可走方向
//     
//             //试探八个方向
//             for(k=0; k<8; k++) {
//                 tmpX = i + ktmoveX[k];
//                 tmpY = j + ktmoveY[k];
//                 //边界 跳过
//                 if(tmpX<0 || tmpY<0 || tmpX>7 || tmpY>7) {
//                     continue;
//                 }
//                 //可走 记录
//                 if(pos[tmpX][tmpY] == 0) {
//                     nextX[l] = tmpX;
//                     nextY[l] = tmpY;
//                     l++;    //可走方向加1
//                 }
//             }
//             count = l;
//             //无路可走 返回
//             if(count == 0) {
//                 return 0;
//             //一个方向可走 标记
//             }else if(count == 1) {
//                 min = 0;
//             //找出下个位置出路个数
//             }else {
//                 for(l=0; l<count; l++) {
//                     for(k=0; k<8; k++) {
//                         tmpX = nextX[l] + ktmoveX[k];
//                         tmpY = nextY[l] + ktmoveY[k];
//                         if(tmpX<0 || tmpY<0 || tmpX>7 || tmpY>7) {
//                             continue;
//                         }
//                         if(pos[tmpX][tmpY] == 0) {
//                             exists[l]++;
//                         }
//                     }
//                 }
//                 //找出下个位置出路最少的方向
//                 min = 0;
//                 tmp = exists[0];
//                 for(l=0; l<count; l++) {
//                     if(exists[l] < tmp) {
//                         tmp = exists[l];
//                        min = l;
//                    }
//                }
//            }
//            //用序号标记走过的位置
//            i = nextX[min];
//            j = nextY[min];
//            pos[i][j] = m;
//        }
//        return 1;
        
    List<Direction> dirs = new ArrayList<Direction>();
    public KnightTour(){
      super();
      int[] ktmoveX = {1,  2,  2, 1, -1, -2, -2, -1};
      int[] ktmoveY = {-2, -1, 1, 2,  2,  1, -1, -2};
        for (int i = 0; i < ktmoveX.length; i++) {
            Direction d = new Direction(ktmoveX[i], ktmoveY[i]);
            dirs.add(d);
        }
    }
    
    int[][] checkerboard = new int[8][8];
        
    class Knight{
        Direction dir;
        Direction nextDir;
        List<Knight> nextKnights;
        
        public Knight(){
            super();
        }
        public Knight(Direction dir){
            super();
            this.dir = dir;
            getNextStepNum();
        }
        
        
        int nextStepNum = 0;
        private int getNextStepNum(){
            for (Direction d : dirs) {
                int tempX = dir.getX() + d.getX(); 
                int tempY = dir.getY() + d.getY(); 
                if(tempX<0 || tempY<0 || tempX>7 || tempY>7){
                    continue;
                }
                if(checkerboard[tempX][tempY] == 0){
                    nextStepNum++;
                    Knight k = new Knight(new Direction(tempX, tempY));
                    nextKnights.add(k);
                }
            }
            return nextStepNum;
        }
        
        
        private void move(){
            if(nextStepNum == 0){
                return;
            }
            for (Knight k : nextKnights) {
                k.getNextStepNum();
            }
            
            Knight k = new Knight(nextDir);
            
            if(checkerboard[0][0] == 0){
                
            }
            return;
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
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}

