package test.java.fr.univavignon.pokedex.impl;

import test.java.fr.univavignon.pokedex.api.IPokemonFactoryTest;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import org.junit.Test;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.impl.PokemonFactory;

public class IPokemonFactoryImplTest extends IPokemonFactoryTest{

	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		PokemonFactory pokefactoryImp = new PokemonFactory();
		Pokemon pokeObtained = pokefactoryImp.createPokemon(0, 613, 64,4000, 4);
		assertEquals(126,pokeObtained.getAttack());
		assertEquals(126,pokeObtained.getDefense());
		assertEquals(613,pokeObtained.getCp());
		assertEquals(4,pokeObtained.getCandy());
		assertEquals(4000,pokeObtained.getDust());
		assertEquals(64,pokeObtained.getHp());
		assertEquals(0,pokeObtained.getIndex());
		assertEquals("Bulbasaur",pokeObtained.getName());
		assertEquals(90,pokeObtained.getStamina());
		assertEquals(84.4,pokeObtained.getIv(),0.01);
	}
	
}



