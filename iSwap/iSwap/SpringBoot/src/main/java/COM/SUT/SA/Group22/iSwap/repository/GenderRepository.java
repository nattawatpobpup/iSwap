package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findById(long id);
    Gender findByGendertype(String gendertype);
}
