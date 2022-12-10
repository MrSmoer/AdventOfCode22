package Days.Day03;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Rucksack> saecke;
    public Group(){
        this.saecke = new ArrayList<>();
    }

    public void addRucksack(Rucksack sack){
        this.saecke.add(sack);
    }

    public char getBadge(){
        if(saecke.size()<2)
            return (char)'a'-1;
        for (char badge : saecke.get(0).content.toCharArray()){
            boolean containedInAll = true;
            for (int i = 1; i<saecke.size(); i++){
                if (!saecke.get(i).content.contains(badge+""))
                    containedInAll = false;
            }
            if (containedInAll)
            return badge;
        }
        return (char)'a';
    }
}
