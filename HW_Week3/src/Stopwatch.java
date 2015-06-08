/**
 * Created by Muffin on 31-5-2015.
 */
public class Stopwatch {
    long begintime, endtime;

    public Stopwatch(){
        this.begintime = 0;
        this.endtime = 0;
    }

    public void start(){
        this.begintime = System.nanoTime();
    }

    public void stop(){
        this.endtime = System.nanoTime();
    }

    public void reset(){
        this.begintime = 0;
        this.endtime = 0;
    }

    public void watch(){
        double wtf = (double)(this.endtime-this.begintime) / (double)1000000;
        System.out.format("Time elapsed in ms: %f\n ", wtf);

        this.reset();
    }
}
