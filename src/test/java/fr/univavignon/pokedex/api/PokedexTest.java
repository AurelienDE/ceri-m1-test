package test.java.fr.univavignon.pokedex.api;


import static org.junit.Assert.*;

import org.junit.Test;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.impl.Pokedex;
import fr.univavignon.pokedex.impl.PokemonFactory;
import fr.univavignon.pokedex.impl.PokemonMetadataProvider;

public class PokedexTest {
	
	@Test
	public void test() throws PokedexException {
		PokemonMetadataProvider meta= new PokemonMetadataProvider();
		PokemonFactory factory = new PokemonFactory();
		Pokedex pokedex = new Pokedex(meta,factory);
		pokedex.initListOnDisk();
		
		assertEquals(null,pokedex.getPokemon(0));
		Pokemon pokemon = new Pokemon(1, "Bulbizarre", 0, 0, 0, 0, 0, 0, 0, 0);
		pokedex.addPokemon(pokemon);
		assertEquals(pokemon,pokedex.getPokemon(0));
		
	}
}
