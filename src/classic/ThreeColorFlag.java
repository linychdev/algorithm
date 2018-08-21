package classic;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ɫ������
 * ��ɫ�������������E.W.Dijkstra����ģ�����ʹ�õ�����ΪDutch Nation Flag��DijkstraΪ�����ˣ�����������������ʹ��Three-Color Flag����֮��
 * ������һ�����ӣ������к졢�ס���������ɫ�����ӣ���������ϵ����ӵ���ɫ��û��˳����ϣ����֮���ಢ����Ϊ�����ס����˳��Ҫ����ƶ��������٣�ע����ֻ���������Ͻ����������������һ��ֻ�ܵ����������ӡ�
 * ͨ�׵�˵��:��123��������ÿ�����ֵĸ������������ּ�˳�򲻶���Ҫ�������ٵĲ��������ĳ�111222333�������������ͬ���ְ��ţ���ͬ���ְ�˳�����С�
 * 
 * ʱ�临�Ӷȵļ���
 * �����г���Ϊnʱ����Ҫѭ��n�Σ��ʶ�ʱ�临�Ӷ�ΪO(n)
 * ThreeColorFlag
 * @author linych
 * @version 1.0
 *
 */
public class ThreeColorFlag {
    List<String> flags = new ArrayList<String>();

    public ThreeColorFlag(){
        init();
    }
    
    private void init(){
        flags.add("r");
        flags.add("w");
        flags.add("w");
        flags.add("b");
        flags.add("w");
        flags.add("b");
        flags.add("r");
        flags.add("b");
        flags.add("w");
        flags.add("r");
    }
    
    private void swap(int x, int y){
        String temp = flags.get(x);
        flags.set(x,flags.get(y));
        flags.set(y, temp);
    }
    
    public static void main(String[] args) {
        ThreeColorFlag tcf = new ThreeColorFlag();
        System.out.println(tcf.flags);
        int bflag = 0;
        int wflag = 0;
        int rflag = tcf.flags.size() - 1;
        while (wflag <= rflag) {
            if(tcf.flags.get(wflag).equals("w")){
                wflag++; 
            }else if(tcf.flags.get(wflag).equals("b")){
                tcf.swap(bflag, wflag);
                bflag++;
                wflag++; 
            }else{
                while(wflag < rflag && tcf.flags.get(rflag).equals("r")){
                    rflag--;
                }
                tcf.swap(wflag, rflag);
                rflag--;
            }
        }
        System.out.println(tcf.flags);
    }
}