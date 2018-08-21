package classic;

import java.util.ArrayList;
import java.util.List;

/**
 * 쳲��������У�Fibonacci sequence�����ֳƻƽ�ָ����С�����ѧ���а��ɶࡤ쳲�������Leonardoda Fibonacci�������ӷ�ֳΪ���Ӷ����룬
 * ���ֳ�Ϊ���������С���ָ��������һ�����У�1��1��2��3��5��8��13��21��34������
 * ����ѧ�ϣ�쳲��������������±��Ե��Ƶķ������壺F(1)=1��F(2)=1, F(n)=F(n-1)+F(n-2)��n>=2��n��N*��
 * 
 * ʱ�临�Ӷȵļ���
 * �����г���Ϊnʱ����Ҫѭ��n-2�Σ��ʶ�ʱ�临�Ӷ�ΪO(n)
 * ���⣬�ݹ鷽��ΪO(2^n)������ⷨΪO(log n),��ʱ�䲹�����ʵ��
 * Fibonacci
 * @author linych
 * @version 1.0
 *
 * 
 * 
 */
public class Fibonacci {
    //Ҳ���Բ���ÿ����ֵ����¼������ֻ��¼2���ͺã���ʡ�ռ�
    private List<Integer> list = new ArrayList<>();
    private List<Integer> fun(int n){
        if(n == 0 || n == 1){
            return list;
        }else{
            for (int i = 2; i <= n; i++) {
                list.add(i, list.get(i-1) + list.get(i-2));
            }
            return list;
        }
    }
    
    public Fibonacci(){
        list.add(0, 1);
        list.add(1, 1);
    }
    
    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        System.out.println(test.fun(10));
    }
}