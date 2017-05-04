package fr.univavignon.pokedex.api;

import java.io.IOException;
import java.net.MalformedURLException;

public class PokemonFactory implements IPokemonFactory {
	
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws MalformedURLException, PokedexException, IOException{
		
		PokemonMetadata medatadatPokemo = 
				new PokemonMetadataProvider().getPokemonMetadata(index);
		
		Pokemon poke = new Pokemon(index,medatadatPokemo.getName(),medatadatPokemo.getAttack(),
						medatadatPokemo.getDefense(),medatadatPokemo.getStamina(),
						cp, hp, dust, candy, 0);
		return poke;
	}

}

			
