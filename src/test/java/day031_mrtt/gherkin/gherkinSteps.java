package day031_mrtt.gherkin;

import io.cucumber.java.en.Given;

public class gherkinSteps {
    @Given("{string}nin kilosu {int} tl")
    public void ninKilosuTl(String arg0, int arg1) {
        System.out.println("1:" + arg0 + "," + arg1);
    }

    @Given("{string} fiyati {double} tl")
    public void fiyatiTl(String arg0, double arg1) {
        System.out.println("2:" + arg0 + "," + arg1 );
    }

    @Given("Türkiyenin baskenti ankaradir")
    public void türkiyeninBaskentiAnkaradir() {
        System.out.println("3:" );

    }

    @Given("sayilarimiz {int}, {int}, {int}, {int}, {int} olsun")
    public void sayilarimizOlsun(int arg0, int arg1, int arg2, int arg3, int arg4) {
        System.out.println(" 4:" + arg0 + "," + arg1 + "," + arg2 + "," + arg3 + "," + arg4 );
    }
}
