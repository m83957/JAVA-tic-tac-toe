import java.util.HashMap;

public class ssss {
    public static void main(String[] args){
        HashMap<String,Integer> pantry = new HashMap<>();
        pantry.put("apple",3);
        pantry.put("orange",2);
        int aaa = pantry.get("apple");
        pantry.put("apple",aaa+4);
        System.out.println(pantry.get("apple"));
    }
}
