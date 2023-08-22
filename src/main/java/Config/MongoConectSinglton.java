package Config;

import Entity.Entrance;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoConectSinglton {
   private static Document document;
   private static MongoCollection<Document> collectionUser;
    private static MongoCollection<Document> collectionPersonage;

    public static MongoCollection<Document> getCollectionPersonage() {

        String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("duel");
        collectionPersonage = database.getCollection("personage");
        return collectionPersonage;
    }

    public static void setCollectionPersonage(MongoCollection<Document> collectionPersonage) {

        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder()
                        .register(
                                ClassModel.builder(Entrance.class).enableDiscriminator(true).build()
                        ).automatic(true)
                        .build()
                )
        );
        String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("duel");
        collectionPersonage = database.getCollection("personage");
        collectionPersonage.withCodecRegistry(codecRegistry);

        MongoConectSinglton.collectionPersonage = collectionPersonage;


    }

    public static MongoCollection<Document> getCollectionUser() {
        String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("duel");
        collectionUser = database.getCollection("users");
        return collectionUser;
    }

    public static void setCollectionUser(MongoCollection<Document> collectionUser) {
        String uri = "mongodb+srv://allxundermark:58645842@duel.axnqaaj.mongodb.net/";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("duel");
        collectionUser = database.getCollection("users");
        MongoConectSinglton.collectionUser = collectionUser;
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
        collectionUser = database.getCollection("users");
        System.out.println("є колекція");

        // collection.find().forEach(doc -> System.out.println(doc.toJson()));

        document = new Document("name", name)
                .append("pass", password);

        collectionUser.insertOne(document);

    } catch (Exception e) {
        System.err.println(e.getCause());
    }
return instance;
}
}
