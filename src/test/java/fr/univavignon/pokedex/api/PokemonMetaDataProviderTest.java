package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.impl.PokemonMetadataProvider;



public class PokemonMetaDataProviderTest {

	PokemonMetadataProvider testList = new PokemonMetadataProvider();
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException {
		PokemonMetadata listeLigne = testList.getPokemonMetadata(150);
		System.out.println(listeLigne.getName());
		
	}
}
