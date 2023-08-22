package Servlet;

import Config.MongoConectSinglton;
import Entity.Entrance;
import com.mongodb.client.MongoCollection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.bson.Document;

import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;

@WebServlet("/UsersServlet")
public class UsersServlet extends jakarta.servlet.http.HttpServlet {

    Entrance entrance = new Entrance();
    MongoConectSinglton mongoConectSinglton;
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        entrance = (Entrance) session.getAttribute("entrance");
//
//
//        String name = request.getParameter("name");
//        String password = request.getParameter("pass");
//
//        entrance.setName(name);
//        entrance.setPass(password);

        MongoCollection<Document> collectionUser = mongoConectSinglton.getCollectionUser();
        entrance.setHp(collectionUser.distinct("personage.hp", eq("name", entrance.getName()), Integer.class).first());
        entrance.setDamage(collectionUser.distinct("personage.damage", eq("name",entrance.getName()), Integer.class).first());
        entrance.setProtection(collectionUser.distinct("personage.protection", eq("name",entrance.getName()), Integer.class).first());


    }
    }
