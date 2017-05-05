package fr.univavignon.pokedex.impl;

import java.io.IOException;
import java.net.MalformedURLException;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonFactory implements IPokemonFactory {
	
	public PokemonFactory(){
		
	}
	
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws MalformedURLException, PokedexException, IOException, InterruptedException{
		
		PokemonMetadata medatadatPokemo = 
				new PokemonMetadataProvider().getPokemonMetadata(index);
		
		CalculIVIsEasyGame calculator = new CalculIVIsEasyGame();
		double iv=calculator.findIV(medatadatPokemo.getName(), cp, hp, dust);
		
		Pokemon poke = new Pokemon(index,medatadatPokemo.getName(),medatadatPokemo.getAttack(),
						medatadatPokemo.getDefense(),medatadatPokemo.getStamina(),
						cp, hp, dust, candy, 0);
		return poke;
	}

}

			