package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

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

@RunWith(MockitoJUnitRunner.class)
public class IPokemonMetadataProviderTest {

	
	PokemonMetadata pokemonMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
	
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
	}
	
	@Mock
	IPokemonMetadataProvider pokemonMetadataProvider;
	
	@Test
	public void test() throws PokedexException {
		assertEquals("Bulbizarre",pokemonMetadataProvider.getPokemonMetadata(0).getName());
		assertEquals(0,pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
		assertEquals(126,pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
		assertEquals(126,pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
		assertEquals(90,pokemonMetadataProvider.getPokemonMetadata(0).getStamina());
		
	}

}
