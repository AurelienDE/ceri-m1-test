package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class IPokedexFactoryTest {

	// A rendre pour le 5 mai a felix.voituret@ismart.fr*
	// token coverage : f923e3e736b04d10b121ac9a9e4124ba
	// pok
	private PokemonMetadata pokemonMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
	private Pokemon pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64, 4000, 4, 56);

	@Mock
	private IPokedexFactory pokedexFactory;
	@Mock
	private IPokemonMetadataProvider pokemonMetadataProvider;
	@Mock
	private IPokemonFactory pokemonFactory;
	@Mock
	private IPokedex pokedex;
	
	@Before
	public void setUp() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64,4000, 4)).thenReturn(pokemon);
		Mockito.when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)).thenReturn(pokedex);
	}
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		assertEquals("Bulbizarre",pokemonMetadataProvider.getPokemonMetadata(0).getName());
		assertEquals(4000,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getDust());
		assertEquals(pokedex,pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory));
		
	}

}
