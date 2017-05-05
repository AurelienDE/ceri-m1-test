package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;

public class IPokemonFactoryTest {

	private Pokemon pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64, 4000, 4, 56);
	
	@Mock
	private IPokemonFactory pokemonFactory;
	
	@Before
	public void setUp() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64,4000, 4)).thenReturn(pokemon);
	}
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		assertEquals("Bulbizarre",pokemonFactory.createPokemon(0, 613, 64,4000, 4).getName());
		assertEquals(4000,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getDust());
		assertEquals(126,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getAttack());
		
	}
}
