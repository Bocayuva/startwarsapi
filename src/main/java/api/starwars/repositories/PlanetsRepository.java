package api.starwars.repositories;

import org.bson.types.ObjectId;
import api.starwars.domains.Planets;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetsRepository extends MongoRepository<Planets, String> {
    Planets findBy_id(ObjectId _id);
    Planets findByName(String name);
}
