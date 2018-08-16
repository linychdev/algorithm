package classic;

/**
 * 汉诺塔(递归)
 *
 * 汉诺塔问题:汉诺塔（又称河内塔）问题是源于印度一个古老传说的益智玩具。
 * 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
 * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 * 并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 * 
 * 时间复杂度的计算 
 * 我们可以看出，用递归来解决汉诺塔问题是非常方便的选择，最后我们来分析一下汉诺塔问题的时间复杂度。 
 * 设盘子个数为n时，需要T（n)步，把A柱子n-1个盘子移到B柱子，需要T（n-1)步，A柱子最后一个盘子移到C柱子一步，B柱子上n-1个盘子移到C柱子上T（n-1)步。 
 * 得递推公式T（n）=2T（n-1)+1 
 * 所以汉诺塔问题的时间复杂度为O(2^n);
 * TowersOfHanoi
 * @author linych
 * @version 1.0
 * 
 */
public class TowersOfHanoi {
    private void hanoi(int n, String a, String b, String c){
        if(n == 1){
            //当a上只剩下一个盘,直接挪到c上
            move(a, c);
        }else{
            //先将a上n-1个盘(除了最大的)挪到b上
            hanoi(n-1, a, c, b);
            //将a上的盘(最后剩下的一个,即最大的那个)挪到c上
            move(a, c);
            //将b上面所有的盘挪到c上
            hanoi(n-1, b, a, c);
        }
    }
    
    private void move(String a, String c){
        System.out.println(a+"->"+c);
    }
    public static void main(String[] args) {
        TowersOfHanoi test = new TowersOfHanoi();
        test.hanoi(5, "A", "B", "C");
    }
}
