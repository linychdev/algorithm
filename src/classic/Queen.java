package classic;


/**
 * 八皇后问题
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法
 * 
 * 
 * Queen
 * @author linych
 * @version 1.0
 *
 */
public class Queen{
  //同栏是否有皇后，1表示有
  private int[] column;
  //右上至左下是否有皇后
  private int[] rup;
  //左上至右下是否有皇后
  private int[] lup;
  //解答
  private int[] queen;
  //解答编号
  private int num;
  public Queen(){
  column=new int[8];
  rup=new int[(2*8)];
  lup=new int[(2*8)];
  for(int i=0;i<8;i++)
  column[i]=0;
  for(int i=0;i<(2*8);i++)
  rup[i]=lup[i]=0;  //初始定义全部无皇后
   
  queen=new int[8];
  }
   
  public void backtrack(int i){
      if(i>=8){
          showAnswer();
      }else{
          for(int j=0;j<8;j++){
          if((column[j]==0)&&(rup[i+j]==0)&&(lup[i-j+8]==0)){
              //若无皇后
              queen[i]=j;
              //设定为占用
              column[j]=rup[i+j]=lup[i-j+8]=1;
              backtrack(i+1);  //循环调用
              column[j]=rup[i+j]=lup[i-j+8]=0;
              }
          }
      }
  }
   
  protected void showAnswer(){
      num++;
      System.out.println("\n解答"+num);
       
      for(int y=0;y<8;y++){
          for(int x=0;x<8;x++){
              if(queen[y]==x){
                  System.out.print("Q ");
              }else{
                  System.out.print("# ");
              }
          }
           
          System.out.println();
      }
  }
   
  public static void main(String[]args){
      Queen queen=new Queen();
      queen.backtrack(0);
      }
  }