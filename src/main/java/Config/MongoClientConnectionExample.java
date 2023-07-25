package Config;



import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Iterator;

public class MongoClientConnectionExample {
    public static void main(String[] args) {
     //   String connectionString = "mongodb+srv://testUser1:123qweQWE@cluster0.vuvhlmx.mongodb.net/?retryWrites=true&w=majority";
        String connectionString = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/?retryWrites=true&w=majority";


        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
             //   MongoDatabase database = mongoClient.getDatabase("testDatabase");
                MongoDatabase database = mongoClient.getDatabase("duel");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");


                // Retrieving a collection
            //  MongoCollection<Document> collection = database.getCollection("points");
                MongoCollection<Document> collection = database.getCollection("users");

                // Getting the iterable object
                FindIterable<Document> iterDoc = collection.find();
                int i = 1;
                // Getting the iterator
                Iterator it = iterDoc.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                    i++;
                }


            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}
