package test.java.fr.univavignon.pokedex.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.impl.PokemonMetadataProvider;
import test.java.fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;

public class IPokemonMetadataProviderImplTest extends IPokemonMetadataProviderTest{

	@Test
	public void test() throws PokedexException, MalformedURLException, IOException {
		PokemonMetadataProvider pokedataproviderImp = new PokemonMetadataProvider();
		assertEquals(1,pokedataproviderImp.getPokemonMetadata(0).getIndex());
		assertEquals(126,pokedataproviderImp.getPokemonMetadata(0).getAttack());
		assertEquals(126,pokedataproviderImp.getPokemonMetadata(0).getDefense());
		assertEquals("Bulbasaur",pokedataproviderImp.getPokemonMetadata(0).getName());
		assertEquals(90,pokedataproviderImp.getPokemonMetadata(0).getStamina());
	}
}
