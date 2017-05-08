package test.java.fr.univavignon.pokedex.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.impl.PokedexFactory;
import test.java.fr.univavignon.pokedex.api.IPokedexFactoryTest;

public class IPokedexFactoryImplTest extends IPokedexFactoryTest{
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		/* Test implementation */
		PokedexFactory pokedexFactoryImp = new PokedexFactory();
		IPokedex pokedexImp = pokedexFactoryImp.createPokedex(pokemonMetadataProvider,pokemonFactory);
		pokedexImp.addPokemon(pokemon);
		assertEquals("Bulbasaur",pokedexImp.getPokemon(0).getName());
		assertEquals(126,pokedexImp.getPokemon(0).getAttack());
		assertEquals(126,pokedexImp.getPokemon(0).getDefense());
		assertEquals(613,pokedexImp.getPokemon(0).getCp());
		assertEquals(4,pokedexImp.getPokemon(0).getCandy());
		assertEquals(4000,pokedexImp.getPokemon(0).getDust());
		assertEquals(0,pokedexImp.getPokemon(0).getIndex());
		assertEquals("Bulbasaur",pokedexImp.getPokemon(0).getName());
		assertEquals(90,pokedexImp.getPokemon(0).getStamina());
		
	}
}
