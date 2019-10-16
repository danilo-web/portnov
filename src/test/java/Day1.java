import org.testng.annotations.Test;

public class Day1 {

    @Test
    public void testMet(){
        for (int i = 1; i <= 10; i++){
            if (i%2==0) System.out.println(i);
        }
    }

}
