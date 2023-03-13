package pl.jmekarska;

import org.junit.jupiter.api.Test;
public class FirstTest {

    @Test
    void testIt(){
        assert true == true;
    }

    @Test
    void testIt2(){
        String myName = "Julia";
        String output = String.format("Hello %s", myName);

        assert output.equals("Hello Julia");
    }

    @Test
    void baseSchema(){
        //Arrange // Given  // Input
        //Act     // When   // interaction
        //Assert  // Then   // Output
    }
}
