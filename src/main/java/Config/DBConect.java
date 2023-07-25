package Config;


import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import org.bson.Document;

import java.net.URLEncoder;
import java.util.Iterator;

public class DBConect {

    public static void main(String [] args){

        System.out.println("Початок роботи");

        try{
            /*String username = URLEncoder.encode("<allxunder>", "UTF-8");
            String password = URLEncoder.encode("<58645842>", "UTF-8");
            String cluster = "<clusterName>";
            String authSource = "<authSource>";
            String authMechanism = "<authMechanism>";*/

            String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
            System.out.println("підключаємось");
            MongoClient mongoClient = MongoClients.create(uri);
            System.out.println("є база даних");
            MongoDatabase database = mongoClient.getDatabase("duel");
            MongoCollection<Document> collection = database.getCollection("users");
            System.out.println("є колекція");

           collection.find().forEach(doc -> System.out.println(doc.toJson()));

           Document document = new Document("name", "ert")
                   .append("pass", "34");

           collection.insertOne(document);



          /*  Document document1 = new Document("title", "MongoDB")
                    .append("description", "database")
                    .append("likes", 100)
                    .append("url", "http://www.tutorialspoint.com/mongodb/")
                    .append("by", "tutorials point");

            String  document2 = "{\n" +
                    "  \"title\": \"MongoDB\",\n" +
                    "  \"description\": \"database\",\n" +
                    "  \"likes\": 100,\n" +
                    "  \"url\": \"http://www.tutorialspoint.com/mongodb/\",\n" +
                    "  \"by\": \"tutorials point\"\n" +
                    "}";
*/

           /* try {

                InsertOneResult insertResult = collection.insertOne(document);
                System.out.println("Document inserted with ID: " + insertResult.getInsertedId());
            }

            catch(MongoWriteException e) {
                // write failure happened, handle it here...
            }
            // Getting the iterable object
            FindIterable<Document> iterDoc = collection.find();
            int i = 1;
            // Getting the iterator
            Iterator it = iterDoc.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
                i++;
            }*/

        } catch(Exception e){
            System.err.println(e.getCause());

        }
    }
}

