import java.util.ArrayList;

public class Pokemon {

	private int health;
	private int attack;
	private ArrayList<String> attacks;
	
	public Pokemon(int health, int attack, ArrayList<String> attacks)
	{
		this.health = health;
		this.attack = attack;
		this.attacks = attacks;
	}
	
	public Pokemon(int health, int attack)
	{
		this.health = health;
		this.attack = attack;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	public void setAttacks(ArrayList<String> attacks)
	{
		this.attacks = attacks;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public ArrayList<String> getAttacks()
	{
		return attacks;
	}
}
