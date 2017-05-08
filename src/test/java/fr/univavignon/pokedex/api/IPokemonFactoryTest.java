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
import fr.univavignon.pokedex.impl.PokemonFactory;

public class IPokemonFactoryTest {

	private Pokemon pokemon = new Pokemon(0,"Bulbasaur", 126,126,90,613,64, 4000, 4, 56);
	
	@Mock
	private IPokemonFactory pokemonFactory;
	
	@Before
	public void setUp() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64,4000, 4)).thenReturn(pokemon);
	}
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		assertEquals(126,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getAttack());
		assertEquals(126,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getDefense());
		assertEquals(613,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getCp());
		assertEquals(4,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getCandy());
		assertEquals(4000,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getDust());
		assertEquals(64,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getHp());
		assertEquals(0,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getIndex());
		assertEquals("Bulbasaur",pokemonFactory.createPokemon(0, 613, 64,4000, 4).getName());
		assertEquals(90,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getStamina());

	}
}
