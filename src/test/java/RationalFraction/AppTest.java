package RationalFraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void sum(){
        Fraction fr1 = new Fraction(1, 2);
        Fraction fr2 = new Fraction(2, 3);

        Fraction expectedFraction = new Fraction(7, 6);
        Fraction actualFraction = fr1.addFraction(fr2);

        assertEquals(expectedFraction, actualFraction);
    }

    // @Test
    // public void multiply(){
    //     Fraction fr1 = new Fraction(1, 2);
    //     Fraction fr2 = new Fraction(2, 3);

    //     Fraction expectedFraction = new Fraction(1, 3);
    //     Fraction actualFraction = fr1.multiFraction(fr2);

    //     assertEquals(expectedFraction, actualFraction);
    // }
}