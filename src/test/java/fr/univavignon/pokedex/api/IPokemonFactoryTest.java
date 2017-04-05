package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;

public class IPokemonFactoryTest {

	Pokemon pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64, 4000, 4, 56);
	
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64,4000, 4)).thenReturn(pokemon);
	}
	
	@Mock
	IPokemonFactory pokemonFactory;
	
	@Test
	public void test() throws PokedexException {
		assertEquals("Bulbizarre",pokemonFactory.createPokemon(0, 613, 64,4000, 4).getName());
		assertEquals(4000,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getDust());
		assertEquals(126,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getAttack());
		
	}

}
