package Days.Day15;

public class Range implements Cloneable {
    int xBegin;
    int xEnd;
    int middle;
    int charsToAdd;

    public static boolean print = false;

    public int size() {
        return xEnd - xBegin + 1;
    }

    public int getxBegin() {
        return xBegin;
    }

    public void setxBegin(int xBegin) {
        this.xBegin = xBegin;
    }

    public int getxEnd() {
        return xEnd;
    }

    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public int getCharsToAdd() {
        return charsToAdd;
    }

    public void setCharsToAdd(int charsToAdd) {
        this.charsToAdd = charsToAdd;
    }

    public Range(int middle, int charsToAdd) {
        this.xBegin = middle - charsToAdd;
        this.xEnd = middle + charsToAdd;
        this.middle = middle;
        this.charsToAdd = charsToAdd;
    }

    public boolean containsInt(int testInt) {
        if (testInt <= xEnd && testInt >= xBegin) {
            return true;
        }
        return false;
    }

    public Range setLocation(int begin, int end) {
        this.xBegin = begin;
        this.xEnd = end;
        return this;
    }

    public Range trimOverlaps(Range otherRange) {
        if (containsInt(otherRange.xBegin) || containsInt(otherRange.xEnd)) {
            if (containsInt(otherRange.xBegin) && containsInt(otherRange.xEnd))
                // other is contained, other will trim to null, this can stay
                return this;
            else if (otherRange.containsInt(this.xBegin) && otherRange.containsInt(this.xEnd))
                // this is contained, this trims to null, never gonna happen here, WIERD EDGE
                // CASE WHEN ENDS MATCH
                return null;
            else if (containsInt(otherRange.xBegin))
                // other is shifted to right, so keep left
                return setLocation(this.xBegin, otherRange.xBegin - 1);
            else if (containsInt(otherRange.xEnd))
                // other is shifted to left, so keep right
                return setLocation(otherRange.xEnd + 1, this.xEnd);
            else {
                System.out.println("HEEYYY");
                return null;
            }
        }
        if (!containsInt(otherRange.xBegin) && !containsInt(otherRange.xEnd)
                && otherRange.containsInt(this.xBegin) && otherRange.containsInt(this.xEnd))
            // this is contained, this trims to null,
            return null;
        return this;
    }

    public void print() {
        if (print) {
            String output = " ";
            for (int i = -10; i < this.xBegin - 1; i++) {
                output += '.';
            }
            for (int i = this.xBegin - 1; i < this.xEnd; i++) {
                output += '#';
            }
            for (int i = this.xEnd - 1; i < 35; i++) {
                output += '.';
            }
            output += " begin " + this.xBegin + ", end " + this.xEnd + ", middle " + this.middle;
            System.out.println(output);
        }
    }

    public void print(boolean asf) {
        if (print) {
            String output = "";
            for (int i = -10; i < this.xBegin - 1; i++) {
                output += '.';
            }
            for (int i = this.xBegin - 1; i < this.xEnd; i++) {
                output += '#';
            }
            for (int i = this.xEnd - 1; i < 35; i++) {
                output += '.';
            }
            output += " begin " + this.xBegin + ", end " + this.xEnd + ", middle " + this.middle;
            System.out.println(output);
        }
    }

}
