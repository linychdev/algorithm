package classic;

import java.util.ArrayList;
import java.util.List;

/**
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，
 * 故又称为“兔子数列”，指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 * 
 * 时间复杂度的计算
 * 当数列长度为n时，需要循环n-2次，故而时间复杂度为O(n)
 * 另外，递归方法为O(2^n)，矩阵解法为O(log n),有时间补充代码实现
 * Fibonacci
 * @author linych
 * @version 1.0
 *
 * 
 * 
 */
public class Fibonacci {
    //也可以不将每个数值都记录下来，只记录2个就好，更省空间
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
