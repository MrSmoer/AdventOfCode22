package Days.Day02;

import java.util.ArrayList;
import java.util.List;

public class SecondMatch {
    int score;
    char enemyInput;
    char gameResult;

    public SecondMatch() {
        this.score = 0;
        this.enemyInput = ' ';
        this.gameResult = ' ';
    }

    public SecondMatch(char pEnemyInput, char pGgameResult) {
        this.enemyInput = pEnemyInput;
        this.gameResult = pGgameResult;
        this.score = this.calculateScore();
    }

    public int calculateScore() {
        int result = 0;
        result += this.convertResultToInt(this.gameResult);
        if (this.gameResult == 'Y') {
            result += convertEnemyToInt(enemyInput);
        } else {
            result += getCorrectCharValue(enemyInput, (this.gameResult == 'Z'));
        }
        this.score = result;
        return result;
    }

    private int convertResultToInt(char ch) {
        System.out.println((int) ch);
        //int t = (ch - 88) * 3;
        return ((int) ch - 88) * 3;
    }

    private int convertEnemyToInt(char ch) {
        return (int) ch - 64;
    }

    private int getCorrectCharValue(char enemy, boolean wins) {
        List<Character> chars = new ArrayList<>();
        chars.add('A');
        chars.add('B');
        chars.add('C');
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) == enemy)
                chars.remove(i);
        }
        if (wins == isWinning(chars.get(0), enemy)) {
            return convertEnemyToInt(chars.get(0));
        } else {
            return convertEnemyToInt(chars.get(1));
        }

    }

    private boolean isWinning(char myChar, char enemyChar) {
        int ownN = convertEnemyToInt(myChar); // I generate ABCs Not XYZs
        int enemyN = convertEnemyToInt(enemyChar);
        if (ownN - enemyN == 1 || (ownN == 1 && enemyN == 3)) {
            return true;

        } else
            return false;
    }
}
