package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;

public class IPokedexTest {

	private Pokemon pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64, 4000, 4, 56);
	private List<Pokemon> listepokemon = new ArrayList<Pokemon>();
	
	@Mock
	private IPokedex pokedex;
	
	@Before
	public void setUp() throws PokedexException {
		listepokemon.add(pokemon);
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokedex.size()).thenReturn(0);
		Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(pokemon.getIndex());
		Mockito.when(pokedex.getPokemon(0)).thenReturn(pokemon);
		Mockito.when(pokedex.getPokemons()).thenReturn(listepokemon);
	}
	
	@Test
	public void test() throws PokedexException {
		assertEquals(0,pokedex.size());
		assertEquals(0,pokedex.addPokemon(pokemon));
		assertEquals(pokemon,pokedex.getPokemon(0));
		assertEquals(listepokemon,pokedex.getPokemons());
		
	}
}
