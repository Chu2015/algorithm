package cc150;

import java.util.Arrays;

public class Different {
    public boolean checkDifferent(String iniString) {
        char[] chars = iniString.toCharArray();
        Arrays.sort(chars);
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                return false;
            }
        }
        return true;
    }
}
