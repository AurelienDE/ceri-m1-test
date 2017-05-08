package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

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

@RunWith(MockitoJUnitRunner.class)
public class IPokemonMetadataProviderTest {

	
	private PokemonMetadata pokemonMetadata = new PokemonMetadata(0,"Bulbasaur",126,126,90);
	
	@Mock
	private IPokemonMetadataProvider pokemonMetadataProvider;
	
	@Before
	public void setUp() throws PokedexException, MalformedURLException, IOException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
	}
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException {
		assertEquals("Bulbasaur",pokemonMetadataProvider.getPokemonMetadata(0).getName());
		assertEquals(0,pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
		assertEquals(126,pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
		assertEquals(126,pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
		assertEquals(90,pokemonMetadataProvider.getPokemonMetadata(0).getStamina());
	}

}
