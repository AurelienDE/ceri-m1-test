package test.java.fr.univavignon.pokedex.api;


import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.impl.PokemonMetadataProvider;



public class PokemonMetaDataProviderTest {

	PokemonMetadataProvider testList = new PokemonMetadataProvider();
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException {
		PokemonMetadata listeLigne = testList.getPokemonMetadata(150);
	}
}
