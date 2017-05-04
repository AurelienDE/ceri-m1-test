package fr.univavignon.pokedex.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

	private List<Pokemon> listePokemon;
	private IPokemonMetadataProvider providerMetaData;
	private IPokemonFactory pokeFactory;
	
	public Pokedex(IPokemonMetadataProvider metadataProvider,IPokemonFactory pokemonFactory){
		this.providerMetaData = metadataProvider;
		this.pokeFactory = pokemonFactory;
		listePokemon= new ArrayList<Pokemon>();
	}
	
	
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException, MalformedURLException, IOException {
			PokemonMetadata pokemonMetadata = this.providerMetaData.getPokemonMetadata(index);
		return pokemonMetadata;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy)
			throws MalformedURLException, PokedexException, IOException {
		Pokemon poke = this.pokeFactory.createPokemon(index, cp, hp, dust, candy);
		return poke;
	}

	@Override
	public int size() {
		int size = this.listePokemon.size();
		return size;
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		int indexPre = size();
		this.listePokemon.add(pokemon);
		int index = indexPre+1;
		return index;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		for (int i=0;i<size();i++){
			if (id==this.listePokemon.get(i).getIndex()){
				return this.listePokemon.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Pokemon> getPokemons() {
		return this.listePokemon;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		List<Pokemon> listePokemonRes = new ArrayList<Pokemon>();
		listePokemonRes = this.listePokemon;
		listePokemonRes.sort(order);
		return listePokemonRes;
	}

}
