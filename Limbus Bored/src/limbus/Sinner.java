package limbus;

public class Sinner {
	int hp;
	int def;
	String name;
	String person;
	Skill skill1;
	Skill skill2;
	Skill skill3;
	String passive;
	public Sinner(int hp, int def, String name, String person, Skill skill1, Skill skill2, Skill skill3, String passive) {
		this.hp = hp;
		this.def = def;
		this.name = name;
		this.person = person;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.passive = passive;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Skill getSkill1() {
		return skill1;
	}

	public void setSkill1(Skill skill1) {
		this.skill1 = skill1;
	}

	public Skill getSkill2() {
		return skill2;
	}

	public void setSkill2(Skill skill2) {
		this.skill2 = skill2;
	}

	public Skill getSkill3() {
		return skill3;
	}

	public void setSkill3(Skill skill3) {
		this.skill3 = skill3;
	}

	public String getPassive() {
		return passive;
	}

	public void setPassive(String passive) {
		this.passive = passive;
	}

	public String toString() {
		return ("Name: " + name + "\nIdentity: " + person + "\nSKILL 1: " + skill1.toString() + "\nSKILL 2: " + skill2.toString() + "\nSKILL 3: " + skill3.toString() + "\nPassive: " + passive + "\nHP: " + hp + "\nDefense: " + def + "\n");
	}
}
