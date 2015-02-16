package Uebungen.Kleinkram.Threads;

/**
 * Created by lnerlich on 13.02.2015.
 */
public class ThreadedCounter2nd extends Thread {

    public void run(){
        for(int i = 0; i < 1000; i++){
            if (i % 10 == 0){
                System.out.println("2: " + i);
            }
        }
    }
}
