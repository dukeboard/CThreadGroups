package org.kevoree.cthreadgroups;

/**
 * Created by duke on 07/01/2014.
 */
public class Tester implements Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(new Tester());
        Thread t2 = new Thread(new Tester());
        t.start();
        t2.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(GetThreadID.getTid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
