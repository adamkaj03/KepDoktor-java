public class Main {
    public static void main(String[] args) {
        KeyManager km = new KeyManager();
        int a1 = km.getKey(); //0
        int a2 = km.getKey(); // 0 1
        int a3 = km.getKey();  //0 1 2
        int a4 = km.getKey();
        km.releaseKey(a3);
        System.out.println("Felszabaditas utan:");
        for(int i=0; i<km.listAll().size(); i++){
            System.out.println(km.listAll().get(i));
        }
    }
}