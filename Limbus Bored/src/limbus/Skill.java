package limbus;
import java.security.SecureRandom;
import java.util.Scanner;
public class Skill {
	int coins;
	int baseatk;
	int atkGrowth;
	String affinity; //lust, greed, envy, etc...
	String name;
	String description;
	String damageType;
	
	public Skill(int coins, int atk, int atkgrowth, String affinity, String name, String description, String damageType) {
		this.coins = coins;
		this.baseatk = atk;
		this.atkGrowth = atkgrowth;
		this.affinity = affinity;
		this.name = name;
		this.description = description;
		this.damageType = damageType;
	}
	
	
	public int getCoins() {
		return coins;
	}


	public void setCoins(int coins) {
		this.coins = coins;
	}


	public int getBaseatk() {
		return baseatk;
	}


	public void setBaseatk(int baseatk) {
		this.baseatk = baseatk;
	}


	public int getAtkGrowth() {
		return atkGrowth;
	}


	public void setAtkGrowth(int atkGrowth) {
		this.atkGrowth = atkGrowth;
	}


	public String getAffinity() {
		return affinity;
	}


	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int simulateClash(int sp, int enemyCoin, int enemyBaseAtk, int enemyAtkGrowth, int enemySP) throws InterruptedException {
		SecureRandom rand = new SecureRandom();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("(Hit enter to continue simulation)");
		int counter = coins;
		int playerTotal = 0;
		int enemyTotal = 0;
		int clashNum = 0;
		while(counter > 0 && enemyCoin > 0) {
			System.out.print("Player coins: ");
			playerTotal += baseatk;
			for(int i = counter; i > 0 ; i--) {
				if(rand.nextInt(1, 100) <= (50 + sp) ) {
					playerTotal += atkGrowth;
					System.out.print("○");
				}else 
					System.out.print("⬤");
			}
			System.out.print("\nEnemy coins: ");
			enemyTotal += enemyBaseAtk;
			for(int i = enemyCoin; i > 0; i--){
				if(rand.nextInt(1, 100) <= (50 + enemySP)) {
					enemyTotal += enemyAtkGrowth;
					System.out.print("○");
				}else
					System.out.print("⬤");
			}
			System.out.println("");
			System.out.println("Player dmg total: " + playerTotal);
			System.out.println("Enemy dmg total: " + enemyTotal);
			if(playerTotal > enemyTotal) {
				enemyCoin--;
				clashNum++;
				System.out.println("Player clash win on clash #" + clashNum + ". Enemy now has " + enemyCoin + " coins");
				input.nextLine();
			}
			else if(enemyTotal > playerTotal){
				counter--;
				clashNum++;
				System.out.println("Enemy clash win on clash #" + clashNum + ". Player now has " + counter + " coins");
				input.nextLine();
			}
			else {
				clashNum++;
				System.out.println("Clash tie on clash #" + clashNum);
				input.nextLine();
			}
			playerTotal = 0;
			enemyTotal = 0;
		}
		if(counter != 0) {
			playerTotal += baseatk;
			System.out.print("Player damage coins: ");
			for(int i = counter; i > 0 ; i--) {
				if(rand.nextInt(1, 100) <= (50 + sp) ) {
					playerTotal += atkGrowth;
					System.out.print("○");
				}else
					System.out.print("⬤");
			}
			System.out.println("Your total damage in the clash was " + playerTotal + " with a damage modifier of " + clashNum + " clashes");
			input.nextInt();
			return playerTotal;
		}
		else {
			enemyTotal += enemyBaseAtk;
			System.out.print("Enemy damage coins: ");
			for(int i = enemyCoin; i > 0; i--){
				if(rand.nextInt(1, 100) <= (50 + enemySP)) {
					enemyTotal += enemyAtkGrowth;
					System.out.print("○");
				}else
					System.out.print("⬤");
			}
			System.out.println("You lost the clash and the enemy dealt " + enemyTotal + " damage with a modifier of " + clashNum + " clashes");
			input.nextLine();
			return enemyTotal;
		}
	}
	public String toString() {
		return ("\nSkill name: " + name + "\nDescription: " + description + "\nBase attack value: " + baseatk + "\nCoins: " + coins + "\nAttack growth: " + atkGrowth + "\nAffinity: " + affinity);
	}
}
