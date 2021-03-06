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

	protected PokemonMetadata pokemonMetadata = new PokemonMetadata(0,"Bulbasaur",126,126,90);
	protected Pokemon pokemon = new Pokemon(0,"Bulbasaur", 126,126,90,613,64, 4000, 4, 56);

	@Mock
	protected IPokedexFactory pokedexFactory;
	@Mock
	protected IPokemonMetadataProvider pokemonMetadataProvider;
	@Mock
	protected IPokemonFactory pokemonFactory;
	@Mock
	protected IPokedex pokedex;
	
	@Before
	public void setUp() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64,4000, 4)).thenReturn(pokemon);
		Mockito.when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)).thenReturn(pokedex);
	}
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		assertEquals("Bulbasaur",pokemonMetadataProvider.getPokemonMetadata(0).getName());
		assertEquals(4000,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getDust());
		assertEquals(pokedex,pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory));
	}

}
