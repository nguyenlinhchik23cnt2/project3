package service;
import Entity.book;
import repository.bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class BookService {
    @Autowired private bookrepository repo;

    public List<book> GetAll() { return repo.findAll(); }
    public void Save(book book) { repo.save(book); }
    public book GetById(Long id) { return repo.findById(id).orElse(null); }
    public void Delete(Long id) { repo.deleteById(id); }
}