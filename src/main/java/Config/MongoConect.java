package Config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConect {

    public void conect (String name, String password) {

        try {

            String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
            System.out.println("підключаємось");
            MongoClient mongoClient = MongoClients.create(uri);
            System.out.println("є база даних");
            MongoDatabase database = mongoClient.getDatabase("duel");
            MongoCollection<Document> collection = database.getCollection("users");
            System.out.println("є колекція");

            collection.find().forEach(doc -> System.out.println(doc.toJson()));

            Document document = new Document("name", name)
                    .append("pass", password);

            collection.insertOne(document);

        }catch(Exception e){
            System.err.println(e.getCause());

        }

    }
}
