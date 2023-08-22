package Servlet;

import Config.MongoConectSinglton;
import Entity.Entrance;
import Entity.Personage;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;


@WebServlet("/CharacterSelectionTankServlet")
public class CharacterSelectionTankServlet extends jakarta.servlet.http.HttpServlet {

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

        Document documentTank = collectionPersonages.find(Filters.eq("name", "tank")).first();

        int hpTank = documentTank.getInteger("hp");
        int damageTank = documentTank.getInteger("damage");
        int protectionTank = documentTank.getInteger("protection");
        collectionUser.updateOne(Filters.eq("name", ss), Updates.combine(
                Updates.set("personage.hp", hpTank),
                Updates.set("personage.damage",damageTank),
                Updates.set("personage.protection",protectionTank)));


        entrance.setHp(collectionUser.distinct("personage.hp", eq("name", ss), Integer.class).first());
        entrance.setDamage(collectionUser.distinct("personage.damage", eq("name",ss), Integer.class).first());
        entrance.setProtection(collectionUser.distinct("personage.protection", eq("name",ss), Integer.class).first());
        session.setAttribute("entrance", entrance);

        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);


    }
}
