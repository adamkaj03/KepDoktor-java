import java.util.*;

public class KeyManager {
    private Set<Integer> keys;
    private int minAvaivableKey;

    public KeyManager(){
        keys = new HashSet<>();
        minAvaivableKey = 0;
    }

    public int getKey(){
        int originalKey = minAvaivableKey;
        keys.add(minAvaivableKey);
        minAvaivableKey++;
        while(keys.contains(minAvaivableKey)){
            minAvaivableKey++;
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
        List<Integer> list = new ArrayList<>(keys.stream().toList());
        Collections.sort(list);
        return list;
    }

}
