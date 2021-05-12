package OOP.baitap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long start() {
        return System.currentTimeMillis();
    }

    public long stop() {
        return System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return stop() - startTime;
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        int[] arr = new int[100000];
        for (int i=0;i<100000;i++){
            arr[i]=(int) Math.random()*10000;
        }
        watch.start();
        Arrays.sort(arr);
        watch.stop();
        System.out.println(watch.getElapsedTime());
    }
}
