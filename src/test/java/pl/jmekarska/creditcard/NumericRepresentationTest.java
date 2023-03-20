package pl.jmekarska.creditcard;
import org.junit.jupiter.api.Test;

public class NumericRepresentationTest {
    @Test
    void lestCheckDouble(){
        double a = 0.01;
        double b = 0.02;
        double c = b - a;
        System.out.println(c);
    }

    @Test
    void lestCheckFloats(){
        float a = 0.01f;
        float b = 0.02f;
        float c = b - a;
        System.out.println(c);
    }
}
