package Days.Day04;

public class Section {
    int begin;
    int end;

    public Section(int pBegin, int pEnd) {
        this.begin = pBegin;
        this.end = pEnd;
    }

    public boolean fullyContains(Section otherSection) {
        if (otherSection.begin >= this.begin && otherSection.end <= this.end)
            return true;
        else
            return false;
    }

    public boolean overlaps(Section otherSection) {
        int tBeg = this.begin;
        int tEnd = this.end;
        int oBeg = otherSection.begin;
        int oEnd = otherSection.end;
        // contains begin
        if (oBeg >= tBeg && oBeg <= tEnd)
            return true;
        // contains end
        if (oEnd >= tBeg && oEnd <= tEnd)
            return true;
        return false;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }
}
