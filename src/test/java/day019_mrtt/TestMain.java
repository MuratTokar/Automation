package day019_mrtt;

public class TestMain {
    public static void main(String[] args) {



        Methods m1=new Methods();

        m1.get("https://google.com");
        Methods m2=new Methods();
        m2.get("https://yahoo.com");
        m1.quit();
        m2.quit();

    }
}
