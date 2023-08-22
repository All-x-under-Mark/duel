package Servlet;

import Config.MongoConectSinglton;
import Entity.Entrance;
import Entity.Personage;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.bson.Document;

import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;

@WebServlet("/CharacterSelectionStrongmanServlet")
public class CharacterSelectionStrongmanServlet extends jakarta.servlet.http.HttpServlet {

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

        Document documentStrongman = collectionPersonages.find(Filters.eq("name", "strongman")).first();

        int hpStrongman = documentStrongman.getInteger("hp");
        int damageStrongman = documentStrongman.getInteger("damage");
        int protectionStrongman = documentStrongman.getInteger("protection");
        collectionUser.updateOne(Filters.eq("name", ss), Updates.combine(
                Updates.set("personage.hp", hpStrongman),
                Updates.set("personage.damage",damageStrongman),
                Updates.set("personage.protection",protectionStrongman)));

        entrance.setHp(collectionUser.distinct("personage.hp", eq("name", ss), Integer.class).first());
        entrance.setDamage(collectionUser.distinct("personage.damage", eq("name",ss), Integer.class).first());
        entrance.setProtection(collectionUser.distinct("personage.protection", eq("name",ss), Integer.class).first());
        session.setAttribute("entrance", entrance);

        getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);


    }
}
