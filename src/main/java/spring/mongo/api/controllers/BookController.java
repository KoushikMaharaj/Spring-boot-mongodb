package spring.mongo.api.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import spring.mongo.api.pojos.Book;
import spring.mongo.api.repository.BookRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private MongoTemplate mongo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {

        bookRepo.save(book);
        return "Added book with id : " + book.getBid();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/findBook/{bid}")
    public Optional<Book> getBook(@PathVariable Integer bid) {
        return bookRepo.findByBid(bid);
    }

    @DeleteMapping("/deleteBook/{bid}")
    public String deleteBook(@PathVariable Integer bid) {
        bookRepo.deleteByBid(bid);
        return "Book deleted with book id : " + bid;
    }

    @DeleteMapping("/deleteAllBooks")
    public String deleteBooks() {
        bookRepo.deleteAll();
        return "OK";
    }

    @PostMapping("/insertJSON")
    public String insertJSON(@RequestBody String inputJson) {

        Document bson = Document.parse(inputJson);
        System.out.println(bson);
        System.out.println(bookRepo.insert(bson));
        //mongo.insert(bson, "Book");
        return "OK";
    }
}
