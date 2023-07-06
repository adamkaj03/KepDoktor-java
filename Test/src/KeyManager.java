import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeyManager {
    private List<Integer> keys;
    private int minAvaivableKey;

    public KeyManager(){
        keys = new ArrayList<>();
        minAvaivableKey = 0;
    }

    public int getKey(){
        int originalKey = minAvaivableKey;
        keys.add(minAvaivableKey);
        boolean isSuccessSet = false;
        int i = 1;
        while(!isSuccessSet){
            if(!keys.contains(minAvaivableKey + i)){
                minAvaivableKey = minAvaivableKey + i;
                isSuccessSet = true;
            }
            i++;
        }
        return originalKey;
    }

    public boolean releaseKey(int key){
        if(keys.contains(key)){
            if(key < minAvaivableKey){
                minAvaivableKey = key;
            }
            keys.remove(Integer.valueOf(key));
            return true;
        }
        else{
            return false;
        }
    }

    public List<Integer> listAll(){
        Collections.sort(keys);
        return keys;
    }

}
