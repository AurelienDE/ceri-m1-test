package test.java.fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.impl.CalculIVIsEasyGame;
import fr.univavignon.pokedex.impl.PokemonMetadataProvider;



public class CaculIIVIsEasyGameTest {

	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {
		CalculIVIsEasyGame calculator = new CalculIVIsEasyGame();
		/* double perfectivpercent =calculator.findIV("bulbizarre", 112, 40, 200);*/
		/* System.out.println(perfectivpercent); */
		
		
	}
}
