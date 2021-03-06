package fr.univavignon.pokedex.impl;

import java.io.IOException;
import java.net.MalformedURLException;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
/* import fr.univavignon.pokedex.impl.CalculIVIsEasyGame; */

public class PokemonFactory implements IPokemonFactory {
	
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws MalformedURLException, PokedexException, IOException, InterruptedException{
		
		PokemonMetadata medatadatPokemo = new PokemonMetadataProvider().getPokemonMetadata(index);
		double iv=0;
		Calculator calculator = new Calculator();
		try {
			calculator.setUp();
			iv=calculator.findIV(medatadatPokemo.getName(), cp, hp, dust);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Impossible d'atteindre l'url");
		}
		Pokemon poke = new Pokemon(index,medatadatPokemo.getName(),medatadatPokemo.getAttack(),
						medatadatPokemo.getDefense(),medatadatPokemo.getStamina(),
						cp, hp, dust, candy, iv);
		return poke;
	}

}

			
