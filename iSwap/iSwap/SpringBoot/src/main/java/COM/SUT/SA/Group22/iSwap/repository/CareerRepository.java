package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CareerRepository extends JpaRepository<Career, Long> {
    Career findById(long id);
    Career findByCareername(String careername);
}
