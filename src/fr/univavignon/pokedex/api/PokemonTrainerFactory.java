package fr.univavignon.pokedex.api;

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
