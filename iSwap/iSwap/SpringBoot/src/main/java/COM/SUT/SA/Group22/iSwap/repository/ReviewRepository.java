package COM.SUT.SA.Group22.iSwap.repository;


import COM.SUT.SA.Group22.iSwap.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController

public interface ReviewRepository extends JpaRepository<Review,Long> {

}
