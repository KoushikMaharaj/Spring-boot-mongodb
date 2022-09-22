package spring.mongo.api.repository;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import spring.mongo.api.pojos.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends MongoRepository<Book, ObjectId> {

    Optional<Book> findByBid(int bid);
    String deleteByBid(int bid);

    Document insert(Document inputJson);
}
