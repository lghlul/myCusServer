import java.util.*;

/**
 * @CLassName Test
 * @Description TODO
 * @Author ll
 * @Date 2018/12/4 14:54
 **/
public class Test {
    public static void main(String[] args) {
        Map<Character , Integer> map = new HashMap<>();
        //String s = "abc";
        String s = "abbcc";
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(map.get(c) == null){
                map.put(c , 0);

            }else{
                Integer i = map.get(c);
                i += 1;
                map.put(c , i);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(Character c : map.keySet()){
            set.add(map.get(c));
        }
        if(set.size() > 2){
            System.out.println(false);
        }else if(set.size() == 2){
            Iterator<Integer> it = set.iterator();
            int m = it.next();
            int n = it.next();
            System.out.println(Math.abs(m - n) == 1);
        }else if(set.size() == 1){
            System.out.println(true);
        }
    }
}
