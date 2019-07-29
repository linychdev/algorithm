package classic;


/**
 * �˻ʺ�����
 * �˻ʺ����⣬��һ�����϶����������⣬�ǻ����㷨�ĵ��Ͱ������������ǹ�����������������˹����ɪ����1848�������
 * ��8��8��Ĺ��������ϰڷŰ˸��ʺ�ʹ�䲻�ܻ��๥���������������ʺ󶼲��ܴ���ͬһ�С�ͬһ�л�ͬһб���ϣ����ж����ְڷ�
 * 
 * 
 * Queen
 * @author linych
 * @version 1.0
 *
 */
public class Queen{
  //ͬ���Ƿ��лʺ�1��ʾ��
  private int[] column;
  //�����������Ƿ��лʺ�
  private int[] rup;
  //�����������Ƿ��лʺ�
  private int[] lup;
  //���
  private int[] queen;
  //�����
  private int num;
  public Queen(){
  column=new int[8];
  rup=new int[(2*8)];
  lup=new int[(2*8)];
  for(int i=0;i<8;i++)
  column[i]=0;
  for(int i=0;i<(2*8);i++)
  rup[i]=lup[i]=0;  //��ʼ����ȫ���޻ʺ�
   
  queen=new int[8];
  }
   
  public void backtrack(int i){
      if(i>=8){
          showAnswer();
      }else{
          for(int j=0;j<8;j++){
          if((column[j]==0)&&(rup[i+j]==0)&&(lup[i-j+8]==0)){
              //���޻ʺ�
              queen[i]=j;
              //�趨Ϊռ��
              column[j]=rup[i+j]=lup[i-j+8]=1;
              backtrack(i+1);  //ѭ������
              column[j]=rup[i+j]=lup[i-j+8]=0;
              }
          }
      }
  }
   
  protected void showAnswer(){
      num++;
      System.out.println("\n���"+num);
       
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