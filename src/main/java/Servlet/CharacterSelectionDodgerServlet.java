package Servlet;

import Config.MongoConectSinglton;
import Entity.Entrance;
import Entity.Personage;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.bson.Document;

import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;

@WebServlet("/CharacterSelectionDodgerServlet")
public class CharacterSelectionDodgerServlet extends jakarta.servlet.http.HttpServlet{
    MongoConectSinglton mongoConectSinglton;
    Entrance entrance = new Entrance();
    Personage personage = new Personage();
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        entrance = (Entrance) session.getAttribute("entrance");
        String ss = entrance.getName();


        MongoCollection<Document> collectionPersonages = mongoConectSinglton.getCollectionPersonage();
        MongoCollection<Document> collectionUser = mongoConectSinglton.getCollectionUser();

        Document documentDodger = collectionPersonages.find(Filters.eq("name", "dodger")).first();

        int hpDodger = documentDodger.getInteger("hp");
        int damageDodger = documentDodger.getInteger("damage");
        int protectionDodger = documentDodger.getInteger("protection");
        collectionUser.updateOne(Filters.eq("name", ss), Updates.combine(
                Updates.set("personage.hp", hpDodger),
                Updates.set("personage.damage",damageDodger),
                Updates.set("personage.protection",protectionDodger)));

        entrance.setHp(collectionUser.distinct("personage.hp", eq("name", ss), Integer.class).first());
        entrance.setDamage(collectionUser.distinct("personage.damage", eq("name",ss), Integer.class).first());
        entrance.setProtection(collectionUser.distinct("personage.protection", eq("name",ss), Integer.class).first());
        session.setAttribute("entrance", entrance);

//        BasicDBObject sercheObject = new BasicDBObject();
//        sercheObject.append("name", ss);
//
//        BasicDBObject updateObject = new BasicDBObject();
//        updateObject.append("$set", new BasicDBObject().append("personage", new Document("hp", hpDodger).append("damage", damageDodger)
//                .append("protection", protectionDodger)));
//
//        collectionUser.updateOne(sercheObject,updateObject);

        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);


    }
}
