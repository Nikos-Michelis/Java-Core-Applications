package classes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Index {
    private ArrayList<LinkedList<String>> ArrayListIndex;

    public Index() {
        ArrayListIndex = new ArrayList<>(26);

        for(int i = 0; i < 26; i++){
            ArrayListIndex.add(new LinkedList<>());
        }
    }
    public void add(String s){
        char c = s.charAt(0);
        int pos = c - 'a';
        if(!ArrayListIndex.get(pos).contains(s)){
            ArrayListIndex.get(pos).add(s);
        }else{
            System.out.println("String " + s + " Exists!");
        }
    }
    @Override
    public String toString() {
        String s = "";
        char   c = 'a';
        for(int i=0; i<ArrayListIndex.size(); i++) {
            s += c + ": ";
            s += String.join(", ", ArrayListIndex.get(i));
            s += "\n";
            c++;
        }
        return s;
    }
}
