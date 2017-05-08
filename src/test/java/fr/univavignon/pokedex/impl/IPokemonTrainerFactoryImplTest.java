package test.java.fr.univavignon.pokedex.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Team;
import fr.univavignon.pokedex.impl.PokemonTrainerFactory;
import test.java.fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;

public class IPokemonTrainerFactoryImplTest extends IPokemonTrainerFactoryTest {
	
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {

		PokemonTrainerFactory poketrainerfactoryImp = new PokemonTrainerFactory();
		Team team=Team.INSTINCT;
		this.setUp();
		assertEquals("Ondine",poketrainerfactoryImp.createTrainer("Ondine",team,pokedexFactory).getName());
		assertEquals(team,poketrainerfactoryImp.createTrainer("Ondine",team,pokedexFactory).getTeam());

	
	}
}
