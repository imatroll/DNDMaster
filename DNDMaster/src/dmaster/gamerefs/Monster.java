package dmaster.gamerefs;

public abstract class Monster {
	Sizes size;
	MonsterTypes mt;
	Alignment align;
	
	int armorClass;
	int landSpeed;
	int seaSpeed;
	int airSpeed;
	int burrowSpeed;
	
	int baseStr;
	int strMod;
	int baseDex;
	int dexMod;
	int baseCon;
	int conMod;
	int baseInt;
	int intMod;
	int baseWis;
	int wisMod;
	int baseCha;
	int chaMod;
	
	Dice hitDie;
	
	int hp = hitDie.rollDice(hitDie) + hitDie.rollDice(hitDie) * conMod;
}
