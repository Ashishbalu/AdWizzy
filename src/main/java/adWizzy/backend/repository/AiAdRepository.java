package adWizzy.backend.repository;

import adWizzy.backend.entity.AiAdInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AiAdRepository extends MongoRepository<AiAdInfo, String> {

    //latest records first-----
    List<AiAdInfo> findTop10ByOrderByCreateAtDesc();
}
