package string.easy.n2;

import java.util.HashMap;

public class BestSolution implements Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();
        char[] sArr = pattern.toCharArray();
        String[] tArr = s.split(" ");

        if(sArr.length != tArr.length){
            return false;
        }

        for(int i = 0; i< sArr.length ; i++){
            if(map.containsKey(sArr[i])){
                if(!tArr[i].equals(map.get(sArr[i]))){
                    return false;
                }
            }else{
                if(map.containsValue(tArr[i])){
                    return false;
                }
                map.put(sArr[i], tArr[i]);
            }
        }

        return true;
    }
}
