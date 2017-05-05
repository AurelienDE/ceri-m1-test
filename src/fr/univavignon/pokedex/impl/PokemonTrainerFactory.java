package fr.univavignon.pokedex.impl;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider() ;
		PokemonFactory pokemonFactory =  new PokemonFactory();
		IPokedex pokedex= pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
		PokemonTrainer pokeTrainer = new PokemonTrainer(name,team,pokedex);
		return pokeTrainer;
	}

}
