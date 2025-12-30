package adWizzy.backend.repository;

import adWizzy.backend.entity.AiAdInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AiAdRepository extends MongoRepository<AiAdInfo, String> {

}
