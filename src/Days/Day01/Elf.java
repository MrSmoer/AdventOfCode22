package Days.Day01;


import java.util.ArrayList;
import java.util.List;

public class Elf {
    List<Integer> items;
    public Elf(){
        items = new ArrayList<>();
    }

    public boolean addItem(int item){
        items.add(item);
        return true;
    }

    public List<Integer> getItems(){
        return items;
    }

    public int getCalories(){
        int calories = 0;
        for (Integer integer : items) {
            calories += integer;
        }
        return calories;
    }
}
