package Days.Day6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Subroutine {
    Queue<Character> queue;
    public Subroutine(){
        this.queue=new ConcurrentLinkedQueue<>();
    }
    public void addChar(char c, int size){
        if (this.queue.size()>=size)
        this.queue.poll();
        this.queue.add(c);
    }

    public boolean isMarker(){
        List<Character> l = new ArrayList<Character>();
        boolean containsIt = false;
        Iterator<Character> itr = this.queue.iterator();
        int queueSize=0;
        while (itr.hasNext())
        {
            char character = itr.next();
            containsIt=containsIt||l.contains(character);
            l.add(character);
                // next() returns the next element in the iteration
            queueSize++;
        }
        if(queueSize<4)
            return false;
        return !containsIt;
    }
}
