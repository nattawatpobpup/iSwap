package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.*;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findById(long id);
    Collection<Item> findByUser(User user);
}