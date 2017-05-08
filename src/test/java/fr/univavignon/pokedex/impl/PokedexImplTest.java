package test.java.fr.univavignon.pokedex.impl;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.impl.Pokedex;
import fr.univavignon.pokedex.impl.PokemonFactory;
import fr.univavignon.pokedex.impl.PokemonMetadataProvider;
import test.java.fr.univavignon.pokedex.api.IPokedexTest;

public class PokedexImplTest extends IPokedexTest {
	
	@Test
	public void test() throws PokedexException {
		PokemonMetadataProvider meta= new PokemonMetadataProvider();
		PokemonFactory factory = new PokemonFactory();
		Pokedex pokedex = new Pokedex(meta,factory);
		pokedex.initListOnDisk();
		assertEquals(null,pokedex.getPokemon(0));
		Pokemon pokemon = new Pokemon(1, "Bulbizarre", 0, 0, 0, 0, 0, 0, 0, 0);
		Pokemon pokemonDeux = new Pokemon(2, "Herbizarre", 0, 0, 0, 0, 0, 0, 0, 0);
		ArrayList<Pokemon> listeTestPoke = new ArrayList<Pokemon>();
		listeTestPoke.add(pokemon);
		listeTestPoke.add(pokemonDeux);
		pokedex.addPokemon(pokemon);
		pokedex.addPokemon(pokemonDeux);
		assertEquals(pokemon,pokedex.getPokemon(0));
		assertEquals(pokemonDeux,pokedex.getPokemon(1));
		assertEquals(listeTestPoke,pokedex.getPokemons());
		assertEquals(2,pokedex.size());
		

		
	}
}
