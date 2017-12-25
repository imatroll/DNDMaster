package dmaster.gamerefs;

import java.util.*;
import java.util.concurrent.*;

public class Dice {
	
	//d2, d3, d4, d5, d6, d7, d8, d0, d12, d16, d20, d24, d30
	int[] values = new int[30];
	
	int maxSides = 0;
	
	public Dice(int sides){
		maxSides = sides;
		for(int x = 1; x < sides; x++){
			values[x-1] = x;
		}
	}
	
	public int rollDice(Dice d){
		Random rand = new Random();
		return rand.nextInt(d.values.length);
	}
	
	public int rollMultDice(Dice d, int dice){
		int min = dice;
		int max = d.maxSides * dice;
		
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	public int rollMultModded(Dice d, int dice, int mod){
		int min = dice;
		int max = d.maxSides * dice;
		
		int result = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		return result + mod;
	}
}
