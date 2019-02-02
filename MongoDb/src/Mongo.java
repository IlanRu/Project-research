import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
public class Mongo {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("testdb");
        MongoCollection<Document> col = database.getCollection("test");
        Document doc = new Document("name", "mongoTest")
                .append("client_name", "Ilan Rubens")
                .append("email", "ilanru@mta.ac.il")
                .append("password", "1234")
                .append("document", "file/path/something.pdf");
        col.insertOne(doc);
        Document myDoc = col.find().first();
        System.out.println(myDoc.toJson());
    }
   /*

    {
        "name" : "MongoDB",
            "type" : "database",
            "count" : 1,
            "versions": [ "v3.2", "v3.0", "v2.6" ],
        "info" : { x : 203, y : 102 }
    }*/


}
