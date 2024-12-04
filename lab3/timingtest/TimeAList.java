package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> a = new AList<>();
        AList<Double> b = new AList<>();
        AList<Integer> b1 = new AList<>();
        int[] w = new int[]{1000,2000,4000,8000,16000,32000,64000};

        for(int i=0;i<w.length;i++){
            int sum = 0;
            int num = w[i];
            b1.addLast(num);
            Stopwatch sw = new Stopwatch();
            while(sum<num){
                sum+=1;
                a.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            b.addLast(timeInSeconds);
        }
        printTimingTable(b1, b, b1);

    }
}
