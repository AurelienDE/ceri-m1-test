package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

public class IPokemonTrainerFactoryTest {
	
	
	//PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory);
	//PokemonTrainer ondine=new PokemonTrainer("ondine", team, pokedex);
	
	private Team team=Team.INSTINCT;
	private PokemonMetadata pokemonMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
	private Pokemon pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64, 4000, 4, 56);

	@Mock
	private IPokemonTrainerFactory pokemonTrainerFactory;
	@Mock
	private IPokedexFactory pokedexFactory;
	@Mock
	private IPokemonMetadataProvider pokemonMetadataProvider;
	@Mock
	private IPokemonFactory pokemonFactory;
	@Mock
	private IPokedex pokedex;
	@Mock
	private PokemonTrainer ondine;
	
	@Before
	public void setUp() throws PokedexException {
		
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64,4000, 4)).thenReturn(pokemon);
		Mockito.when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)).thenReturn(pokedex);
		
		Mockito.when(pokemonTrainerFactory.createTrainer("Ondine",team,pokedexFactory)).thenReturn(ondine);
	}
	
	@Test
	public void test() throws PokedexException {
		assertEquals("Bulbizarre",pokemonMetadataProvider.getPokemonMetadata(0).getName());
		assertEquals(4000,pokemonFactory.createPokemon(0, 613, 64,4000, 4).getDust());
		assertEquals(pokedex,pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory));
		assertEquals(ondine,pokemonTrainerFactory.createTrainer("Ondine",team,pokedexFactory));
		
	}
}
