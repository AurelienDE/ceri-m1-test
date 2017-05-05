package fr.univavignon.pokedex.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class Pokedex implements IPokedex {

	private List<Pokemon> listePokemon;
	private IPokemonMetadataProvider providerMetaData;
	private IPokemonFactory pokeFactory;
	
	public Pokedex(IPokemonMetadataProvider metadataProvider,IPokemonFactory pokemonFactory){
		this.providerMetaData = metadataProvider;
		this.pokeFactory = pokemonFactory;
		listePokemon= new ArrayList<Pokemon>();
	}
	
	public void initListOnDisk(){
		String chaine="";
		String fichier ="src/SavePokedex.json";
		PokemonMetadata pokemonMetaData=null;
		//lecture du fichier json	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			/* Ecrit dans l'ArrayList les pokemons du pokedex sauvegardes */
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException, MalformedURLException, IOException {
			PokemonMetadata pokemonMetadata = this.providerMetaData.getPokemonMetadata(index);
		return pokemonMetadata;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy)
			throws MalformedURLException, PokedexException, IOException, InterruptedException {
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
		String chaine="";
		String fichier ="SavePokedex.txt";
		/* Ecrit dans le fichier de sauvegarde les pokemons ajoutés au pokedex */
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
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
