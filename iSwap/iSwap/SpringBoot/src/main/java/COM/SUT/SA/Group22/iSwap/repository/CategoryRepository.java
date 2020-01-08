package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
	// // Optional<Category> findById(Long categoryid);
	Category findById(long categoryid);

	Category findByCategoryname(String categoryname);
}