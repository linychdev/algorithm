package classic;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

public class KnightTour {
//         int i, j, k, l, m;
//         int tmpX, tmpY;
//         int count, min, tmp;
//     
//         //��ʿ���ߵİ˸�����(˳ʱ��)
//         int[] ktmoveX = {1,  2,  2, 1, -1, -2, -2, -1};
//         int[] ktmoveY = {-2, -1, 1, 2,  2,  1, -1, -2};
//     
//         //��һ������
//         int[] nextX = {0};
//         int[] nextY = {0};
//     
//         //��¼ÿ������ĳ�·�ĸ���
//         int[] exists = {0};
//     
//         //��ʼ��1���λ��
//         i = x;
//         j = y;
//         pos[i][j] = 1;
//     
//         //��������
//         for(m=2; m<=64; m++) {
//             //��ʼ���˸�������ڸ���
//             for(l=0; l<8; l++) {
//                 exists[l] = 0;
//             }
//             l = 0; //������߷���
//     
//             //��̽�˸�����
//             for(k=0; k<8; k++) {
//                 tmpX = i + ktmoveX[k];
//                 tmpY = j + ktmoveY[k];
//                 //�߽� ����
//                 if(tmpX<0 || tmpY<0 || tmpX>7 || tmpY>7) {
//                     continue;
//                 }
//                 //���� ��¼
//                 if(pos[tmpX][tmpY] == 0) {
//                     nextX[l] = tmpX;
//                     nextY[l] = tmpY;
//                     l++;    //���߷����1
//                 }
//             }
//             count = l;
//             //��·���� ����
//             if(count == 0) {
//                 return 0;
//             //һ��������� ���
//             }else if(count == 1) {
//                 min = 0;
//             //�ҳ��¸�λ�ó�·����
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
//                 //�ҳ��¸�λ�ó�·���ٵķ���
//                 min = 0;
//                 tmp = exists[0];
//                 for(l=0; l<count; l++) {
//                     if(exists[l] < tmp) {
//                         tmp = exists[l];
//                        min = l;
//                    }
//                }
//            }
//            //����ű���߹���λ��
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
