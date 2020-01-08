package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface HashtagRepository extends JpaRepository<Hashtag, Long> {
	 Hashtag findById(long hashtagid);
	Hashtag findByHashtagname(String hashtagname);
	
}