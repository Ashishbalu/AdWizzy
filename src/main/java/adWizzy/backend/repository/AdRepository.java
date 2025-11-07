package adWizzy.backend.repository;

import adWizzy.backend.entity.AdInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdRepository extends MongoRepository<AdInfo, ObjectId> {
}
