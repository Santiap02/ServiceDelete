package Repository;

import Model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio base de datos "Test4".
 *
 * @author santiago.alvarezp@udea.edu.co
 *
 */
@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
    Optional<Photo> findByClientId(int title);
    void deleteByClientId(int clientId);
}

