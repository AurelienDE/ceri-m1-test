package fr.univavignon.pokedex.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.*;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;


public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	public PokemonMetadataProvider(){
		
	}
	
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException, MalformedURLException, IOException{
		
		PokemonMetadata pokemonMetaData=null;
		String listeLigne="";
		InputStream in = new URL( "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json" ).openStream();
		 try {
			 listeLigne=listeLigne+IOUtils.toString( in );
		 } finally {
		   IOUtils.closeQuietly(in);
		 }
		 
		 JSONArray array = new JSONArray(listeLigne);
			for (int i=0;i<array.length();i++){
				if (index==i){
					JSONObject jsonObject= array.getJSONObject(i);
					pokemonMetaData = new PokemonMetadata(
						jsonObject.getInt("PkMn"),
						jsonObject.getString("Identifier"),
						jsonObject.getInt("BaseAttack"),
						jsonObject.getInt("BaseDefense"),
						jsonObject.getInt("BaseStamina")		
					);
				}
			}
		 
		return pokemonMetaData;
	}
	
}
