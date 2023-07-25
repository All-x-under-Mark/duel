package Config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConectSinglton {
   private static Document document;
   private static MongoCollection<Document> collection;

    public static MongoCollection<Document> getCollection() {
        String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("duel");
        collection = database.getCollection("users");
        return collection;
    }

    public static void setCollection(MongoCollection<Document> collection) {
        MongoConectSinglton.collection = collection;
    }

    public static Document getDocument() {
        return document;
    }

    public static void setDocument(Document document) {
        MongoConectSinglton.document = document;
    }

    private static MongoConectSinglton instance = new MongoConectSinglton();

private MongoConectSinglton (){

}

public static MongoConectSinglton getInstance(String name, String password){
    try{
        String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
        System.out.println("підключаємось");
        MongoClient mongoClient = MongoClients.create(uri);
        System.out.println("є база даних");
        MongoDatabase database = mongoClient.getDatabase("duel");
        collection = database.getCollection("users");
        System.out.println("є колекція");

        // collection.find().forEach(doc -> System.out.println(doc.toJson()));

        document = new Document("name", name)
                .append("pass", password);

        collection.insertOne(document);

    } catch (Exception e) {
        System.err.println(e.getCause());
    }
return instance;
}
}
