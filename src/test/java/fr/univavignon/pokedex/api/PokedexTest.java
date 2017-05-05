package test.java.fr.univavignon.pokedex.api;


import org.junit.Test;
import fr.univavignon.pokedex.api.PokedexException;
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
		
	}
}
