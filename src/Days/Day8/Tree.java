package Days.Day8;

public class Tree {
    int height;
    boolean alreadyCounted;
    int scenicScore;

    public Tree(int height){
        this.height=height;
        this.alreadyCounted=false;
        this.scenicScore=1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isAlreadyCounted() {
        return alreadyCounted;
    }

    public void setAlreadyCounted(boolean alreadyCounted) {
        this.alreadyCounted = alreadyCounted;
    }

    public void setScenicScore(int scenicScore){
        this.scenicScore = scenicScore;
    }

    public int getScenicScore(){
        return scenicScore;
    }
    
}
