package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int time = 10000;
        AList<Double> b = new AList<>();
        AList<Integer> t = new AList<>();
        AList<Integer> t1 = new AList<>();
        int[] l = new int[]{1000,2000,4000,8000,16000,32000,64000};


        for(int i=0;i<l.length;i++){
            int sum = 0;
            int num = l[i];
            SLList<Integer> a = new SLList<>();
            for(int j=0;j<num;j++){
                a.addFirst(1);
            }
            t.addLast(time);
            t1.addLast(num);
            Stopwatch sw = new Stopwatch();
            while(sum<time){
                sum+=1;
                a.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            b.addLast(timeInSeconds);

        }
        printTimingTable(t1, b,t);

    }

}
