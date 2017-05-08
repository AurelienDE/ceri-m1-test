package test.java.fr.univavignon.pokedex.impl;

import test.java.fr.univavignon.pokedex.api.IPokemonFactoryTest;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import org.junit.Test;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.impl.PokemonFactory;

public class IPokemonFactoryImplTest extends IPokemonFactoryTest{

	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		PokemonFactory pokefactoryImp = new PokemonFactory();
		assertEquals(126,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getAttack());
		assertEquals(126,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getDefense());
		assertEquals(613,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getCp());
		assertEquals(4,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getCandy());
		assertEquals(4000,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getDust());
		assertEquals(64,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getHp());
		assertEquals(0,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getIndex());
		assertEquals("Bulbasaur",pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getName());
		assertEquals(90,pokefactoryImp.createPokemon(0, 613, 64,4000, 4).getStamina());
	}
	
}



