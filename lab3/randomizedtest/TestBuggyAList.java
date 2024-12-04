package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();


        a.addLast(4);
        b.addLast(4);
        a.addLast(5);
        b.addLast(5);
        a.addLast(6);
        b.addLast(6);

        assertEquals(a.size(), b.size());

        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
    }
    @Test
    public void randomizedTest(){
        BuggyAList<Integer> b = new BuggyAList<>();
        int N = 500;
        b.addLast(73);
        b.addLast(76);
        b.addLast(80);
        b.addLast(27);
        b.addLast(3);
        b.addLast(55);
        b.addLast(94);
        b.addLast(39);
        b.addLast(67);
        b.addLast(75);
        b.addLast(0);
        b.addLast(94);
        b.addLast(27);
        b.addLast(80);
        b.addLast(26);
        b.addLast(57);
        b.addLast(74);
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0 ) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                b.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            }else if (operationNumber == 2 || operationNumber == 1) {
                if(b.size()>0){
                    b.removeLast();
                }
            }


        }
    }
}
