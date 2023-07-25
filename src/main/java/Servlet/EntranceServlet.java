package Servlet;

import static com.mongodb.client.model.Filters.eq;
import Config.MongoConectSinglton;
import Entity.Entrance;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import org.bson.Document;

import java.io.IOException;
import java.util.Iterator;



@WebServlet("/EntranceServlet")
public class EntranceServlet extends jakarta.servlet.http.HttpServlet {




    MongoConectSinglton mongoConectSinglton;
    Entrance entrance = new Entrance();
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {

    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String password = request.getParameter("pass");

        entrance.setName(name);
        entrance.setPass(password);

        MongoCollection<Document> collection = mongoConectSinglton.getCollection();

       // FindIterable<Document> iterDoc = collection.find();

       Document entranceDocument = collection.find(eq("name", name)).first();


       if (entranceDocument != null) {

           String nameDB = entranceDocument.getString("name");
           System.out.println("nameDB : " + nameDB);

           String passDB = entranceDocument.getString("pass");
           System.out.println("passDB : " + passDB);

           if (!passDB.equals(password) ) {
               getServletContext().getRequestDispatcher("/entrance.jsp").forward(request, response);

           } else {
               session.setAttribute("entrance", entrance);

               getServletContext().getRequestDispatcher("/duel.jsp").forward(request, response);
           }



       } else {
           mongoConectSinglton = MongoConectSinglton.getInstance(name,password);
           session.setAttribute("entrance", entrance);

           getServletContext().getRequestDispatcher("/duel.jsp").forward(request, response);

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


    //  collection.find().forEach(doc -> System.out.println(doc.toJson()));


    //    mongoConectSinglton = MongoConectSinglton.getInstance(name,password);


        session.setAttribute("entrance", entrance);

        getServletContext().getRequestDispatcher("/duel.jsp").forward(request, response);
    }
}