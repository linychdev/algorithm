package classic;

/**
 * ����һ����ά���飬������2��ʾǽ�ڣ�0��ʾͨ·���ɴ������չʾΪһ���Թ�ͼ��
 * �������λ�úͳ���λ�ã��ж�֮���Ƿ����ͨ·����ʾ���߳��Թ��ĵ�·���ҳ�ȫ��·��
 * MouseMaze2
 * @author linych
 * @version 1.0
 *
 */
public class MouseMaze2 {
    private static int[][] maze = {
                                  {2,2,2,2,2,2,2},
                                  {2,0,0,0,0,0,2},
                                  {2,0,2,2,0,2,2},
                                  {2,0,2,0,0,2,2},
                                  {2,0,2,0,0,0,2},
                                  {2,0,0,0,2,0,2},
                                  {2,2,2,2,2,2,2},
                                  };
    static int startX = 1;
    static int startY = 1;

    static int endX = 5;
    static int endY = 5;
    
    static boolean success = false;
    public static void main(String[] args) {
        move(1,1);
    }

    private static void move(int x, int y){
        maze[x][y] = 1;
        if(x == endX && y == endY){
            printMap();
        }
        
        if(maze[x][y+1] == 0){
            move(x, y+1);
        }
        if(maze[x+1][y] == 0){
            move(x+1, y);
        }
        if(maze[x][y-1] == 0){
            move(x, y-1);
        }
        if(maze[x-1][y] == 0){
            move(x-1, y);
        }
        
        maze[x][y] = 0;
    }
    
    private static void printMap() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 2){
                    System.out.print("��");
                }else if(maze[i][j] == 1){
                    System.out.print("��");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}