package Entity;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import jakarta.enterprise.inject.Model;
import org.bson.Document;

public class Entrance {

    String name;
    String pass;
    String message;
    int hp;
    int damage;
    int protection;
    String namePersonsge;
    String type;

    public Entrance() {
    }

    public Entrance(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }


    public BasicDBObject toDBObject() {
        BasicDBObject doc = new BasicDBObject();

        doc.put("name", name);
        doc.put("pass", pass);
        doc.put("personage", new Document("damage", damage).append("hp", hp)
                .append("protection", protection)
                .append("name_personage", namePersonsge));
        return doc;
    }

    public static Entrance fromDBObject(DBObject document) {
        Entrance entrance = new Entrance();

        entrance.name = (String) document.get("name");
        entrance.pass = (String) document.get("pass");
        entrance.hp = (Integer) document.get("personage.hp");
        entrance.damage = (Integer) document.get("personage.damage");
        entrance.protection = (Integer) document.get("personage.protection");
        entrance.namePersonsge = (String) document.get("personage.name_personage");

       // entrance.hp = (Integer) document.get(String.valueOf(Document.parse("{}")));

        return entrance;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNamePersonsge() {
        return namePersonsge;
    }

    public void setNamePersonsge(String namePersonsge) {
        this.namePersonsge = namePersonsge;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
