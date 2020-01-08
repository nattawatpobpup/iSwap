package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    Shipping findById(long id);

}
