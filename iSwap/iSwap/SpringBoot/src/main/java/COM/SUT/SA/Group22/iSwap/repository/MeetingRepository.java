package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.Meeting;
import COM.SUT.SA.Group22.iSwap.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface MeetingRepository extends JpaRepository<Meeting,Long> {
 //   Collection<Meeting> findByuser(User user);
    Meeting findById(long Id);
    Collection<Meeting> findByProposalIn(Collection<Proposal> proposal);
}