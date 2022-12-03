package Days.Day3;

public class Rucksack {
    String content;
    String compartment1;
    String compartment2;
    public Rucksack(String pContent){
        this.content = pContent;
        int length = content.length();
        if(length<2)
            return;
        this.compartment1 = this.content.substring(0, (length/2));
        this.compartment2 = this.content.substring(length/2);
        //System.out.println(this.compartment1);
        //System.out.println(this.compartment2);
         System.out.println(content);
        }

    public char getOverlappingItem(){
        for(char itemFrom1 : this.compartment1.toCharArray()){
            if(this.compartment2.contains(itemFrom1+"")){
                return itemFrom1;
            }
        }
        return '0';
    }

    public String getCompartment1() {
        return compartment1;
    }
    public String getCompartment2() {
        return compartment2;
    }
}
