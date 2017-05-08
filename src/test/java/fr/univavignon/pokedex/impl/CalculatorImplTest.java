package test.java.fr.univavignon.pokedex.impl;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.pokedex.impl.Calculator;


public class CalculatorImplTest {
	@Test
	public void test() throws Exception  {
		Calculator calculator = new Calculator();
		calculator.setUp();
		assertEquals(84.4,calculator.findIV("Bulbasaur", 613, 64, 4000),0.001);
	}
}


