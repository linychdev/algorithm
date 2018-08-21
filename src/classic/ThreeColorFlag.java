package classic;

import java.util.ArrayList;
import java.util.List;

/**
 * 三色旗问题
 * 三色旗的问题最早由E.W.Dijkstra提出的，他所使用的用语为Dutch Nation Flag（Dijkstra为荷兰人），而多数的作者则使用Three-Color Flag来称之。
 * 假设有一条绳子，上面有红、白、蓝三种颜色的旗子，起初绳子上的旗子的颜色并没有顺序，你希望将之分类并排列为蓝、白、红的顺序，要如何移动次数最少，注意你只能在绳子上进行这个动作，并且一次只能调换两个旗子。
 * 通俗的说法:有123三个数，每个数字的个数不定，数字间顺序不定，要求用最少的步数将他改成111222333这种情况，即相同数字挨着，不同数字按顺序排列。
 * 
 * 时间复杂度的计算
 * 当数列长度为n时，需要循环n次，故而时间复杂度为O(n)
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
