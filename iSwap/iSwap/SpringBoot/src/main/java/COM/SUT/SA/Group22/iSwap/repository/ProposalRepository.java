package COM.SUT.SA.Group22.iSwap.repository;

import COM.SUT.SA.Group22.iSwap.entity.Proposal;
import COM.SUT.SA.Group22.iSwap.entity.ProposalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.*;

@RepositoryRestResource
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    Proposal findById(long id);
    Collection<Proposal> findByUserReceiveName(String userReceiveName);
    Collection<Proposal> findByUserOfferName(String userOfferName);
    Collection<Proposal> findByUserOfferNameAndProposalStatus(String username, ProposalStatus proposalStatus);
    Collection<Proposal> findByUserOfferNameAndProposalStatusOrUserReceiveNameAndProposalStatus(String username1,ProposalStatus proposalStatus1,String username2, ProposalStatus proposalStatus2);
}