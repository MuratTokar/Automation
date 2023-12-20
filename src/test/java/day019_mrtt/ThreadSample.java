package day019_mrtt;

public class ThreadSample {
    public static void main(String[] args) {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    System.out.print(Thread.currentThread().getName() + " : " + i );
                    //Ali:0  Ali:0 Weli:0 Ali:2 Ali:3 Ali:4 Weli:1 Weli:2 Weli:3 Weli:4
                    // Weli:5 Ali:5 Weli:6 Weli:7 Weli:8 Ali:6 Weli:9 Ali:7 Ali:8 Ali:9

                }
            }
        };
        Thread t1=new Thread(r); // burda iki thread yan yana calisiyor.
        t1.setName("Ali");
        Thread t2=new Thread(r);
        t2.setName("Weli");

        t1.start();
        t2.start();


    }
}