package Servlet;

import static com.mongodb.client.model.Filters.eq;
import Config.MongoConectSinglton;
import Entity.Entrance;
import Entity.Personage;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.jstl.core.Config;
import org.bson.*;

import java.io.IOException;
import java.util.Arrays;


@WebServlet("/EntranceServlet")
public class EntranceServlet extends jakarta.servlet.http.HttpServlet {



    int hpTank;

    MongoConectSinglton mongoConectSinglton;

     Entrance entrance = new Entrance();
     Personage personageTank = new Personage();
     Personage personageDodger = new Personage();
     Personage personageStrongman = new Personage();
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {


//        new BsonDocument().append("a", new BsonString("MongoDB"))
//                .append("b", new BsonArray(Arrays.asList(new BsonInt32(1), new BsonInt32(2))));
//


//        collection.replaceOne(eq("item", "paper"),
//                Document.parse("{ item: 'paper', instock: [ { warehouse: 'A', qty: 60 }, { warehouse: 'B', qty: 40 } ] }"));
//
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();



        String name = request.getParameter("name");
        String password = request.getParameter("pass");

        entrance.setName(name);
        entrance.setPass(password);

        MongoCollection<Document> collectionUser = mongoConectSinglton.getCollectionUser();
       MongoCollection<Document> collectionPersonage = mongoConectSinglton.getCollectionPersonage();

       personageTank.setHp(collectionPersonage.distinct("hp", eq("name", "tank"), Integer.class).first());
       personageTank.setDamage((collectionPersonage.distinct("damage", eq("name", "tank"), Integer.class).first()));
       personageTank.setProtection((collectionPersonage.distinct("protection", eq("name", "tank"), Integer.class).first()));




//       entrance.setHp((Integer) entranceDocument.get("personage.hp"));
//       entrance.setDamage((Integer) entranceDocument.get("personage.damage"));
//       entrance.setProtection((Integer) entranceDocument.get("personage.protection"));




       Document personageDocumentTank = collectionPersonage.find(eq("name", "tank")).first();
        Document personageDocumentDodger = collectionPersonage.find(eq("name", "dodger")).first();
        Document personageDocumentStrongman = collectionPersonage.find(eq("name", "strongman")).first();




        hpTank = personageDocumentTank.getInteger("hp");
        session.setAttribute("hpTank", hpTank);



       // FindIterable<Document> iterDoc = collectionUser.find("users");
        Document entranceDocument = collectionUser.find(eq("name", name)).first();

       if (entranceDocument != null) {

           String nameDB = entranceDocument.getString("name");
           System.out.println("nameDB : " + nameDB);

           String passDB = entranceDocument.getString("pass");
           System.out.println("passDB : " + passDB);

           entrance.setHp(collectionUser.distinct("personage.hp", eq("name", name), Integer.class).first());
           entrance.setDamage(collectionUser.distinct("personage.damage", eq("name",name), Integer.class).first());
           entrance.setProtection(collectionUser.distinct("personage.protection", eq("name",name), Integer.class).first());

           if (!passDB.equals(password) ) { // невірний пароль
               getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
              entrance.setMessage("Невірний пароль для гравця " + name + ". Ведіть вірний пароль.");
               session.setAttribute("entrance", entrance);

           } else { // підтвердили пароль
               session.setAttribute("entrance", entrance);


               getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);





           }



       } else { //новий гравець
           mongoConectSinglton = MongoConectSinglton.getInstance(name,password);

//           entrance.setHp(collectionUser.distinct("personage.hp", eq("name", name), Integer.class).first());
//           entrance.setDamage(collectionUser.distinct("personage.damage", eq("name",name), Integer.class).first());
//           entrance.setProtection(collectionUser.distinct("personage.protection", eq("name",name), Integer.class).first());
           session.setAttribute("entrance", entrance);
           getServletContext().getRequestDispatcher("/characterSelection.jsp").forward(request, response);

       }







//        String document2 = "{\n" +
//                "  \"title\": \"MongoDB\",\n" +
//                "  \"description\": \"database\",\n" +
//                "  \"likes\": 100,\n" +
//                "  \"url\": \"http://www.tutorialspoint.com/mongodb/\",\n" +
//                "  \"by\": \"tutorials point\"\n" +
//                "}";
//        int i = 1;

        // Getting the iterator

     // mongoConectSinglton.setCollection(collection);


    // collectionPersonage.find().forEach(doc -> System.out.println(doc.toJson()));


    //    mongoConectSinglton = MongoConectSinglton.getInstance(name,password);


        session.setAttribute("entrance", entrance);

        getServletContext().getRequestDispatcher("/duel.jsp").forward(request, response);
    }
}