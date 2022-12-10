package Days.Day02;

public class Match {
    int score;
    char enemyInput;
    char myInput;
    public Match(){
        this.score=0;
        this.enemyInput = ' ';
        this.myInput = ' ';
    }
    public Match(char pEnemyInput, char pMyInput){
        this.enemyInput=pEnemyInput;
        this.myInput=pMyInput;
        this.score=this.calculateScore();
    }
    public int calculateScore() {
        int result=0;
        result+=this.convertOwnToInt(this.myInput);
        result+=battle(enemyInput, myInput);
        this.score=result;
        return result;
    }
    private int battle(char enemy, char own){
        int enemyN = convertEnemyToInt(enemy);
        int ownN = convertOwnToInt(own);
        if(enemyN==ownN){
            return 3;
        }
        else if(ownN-enemyN==1||(ownN==1&&enemyN==3)){
            return 6;

        } else return 0;
    }
    private int convertOwnToInt(char ch){
        return (int)ch-87;
    }
    private int convertEnemyToInt(char ch){
        return (int)ch-64;
    }
}
