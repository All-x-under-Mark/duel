package Entity;

public class Personage {

    String name;
    int hp;
    int damage;
    int protection;

    String message;


    public Personage() {
    }

    public Personage(String name, int hp, int damage, int protection) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.protection = protection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
