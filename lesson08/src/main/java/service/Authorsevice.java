package service;
import Entity.author;
import repository.authorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
public class Authorsevice {


    @Autowired private authorrepository repo;

    public List<author> GetAll() { return repo.findAll(); }
    public void Save(author author) { repo.save(author); }
    public author GetById(Long id) { return repo.findById(id).orElse(null); }
    public void Delete(Long id) { repo.deleteById(id); }


    public List<author> FindAllByIds(List<Long> ids) {
        return repo.findAllById(ids);
    }

}
