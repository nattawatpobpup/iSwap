package COM.SUT.SA.Group22.iSwap.controller;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProposalController {

    @Autowired
    private ProposalRepository proposalRepository;
    @Autowired
    private ProposalStatusRepository proposalStatusRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private TradeOptionRepository tradeOptionRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addProposal/{Item1Id}/{Item2Id}/{OptionId}/{StatusId}/{description}")
    public Proposal newProposal(Proposal newProposal, @PathVariable Long Item1Id, @PathVariable Long Item2Id,
                                @PathVariable Long OptionId, @PathVariable Long StatusId, @PathVariable String description) {

        Item newItem1 = itemRepository.findById(Item1Id).get();
        Item newItem2 = itemRepository.findById(Item2Id).get();
        TradeOption newOption = tradeOptionRepository.findById(OptionId).get();
        ProposalStatus newProposalStatus = proposalStatusRepository.findById(StatusId).get();

        newProposal.setItemReceive(newItem1);
        newProposal.setItemOffer(newItem2);
        newProposal.setTradeOption(newOption);
        newProposal.setProposalStatus(newProposalStatus);
        newProposal.setDescription(description);

        newProposal.setItemOfferName(newProposal.getItemOffer().getItemName());
        newProposal.setItemReceiveName(newProposal.getItemReceive().getItemName());
        newProposal.setUserOfferName(newProposal.getItemOffer().getUser().getUsername());
        newProposal.setUserReceiveName(newProposal.getItemReceive().getUser().getUsername());

        return proposalRepository.save(newProposal);
    }

    @PutMapping("/updateProposal/{proposal_Id}/{status_Id}")
    Proposal update(Proposal proposal, @PathVariable Long proposal_Id, @PathVariable Long status_Id){
        return proposalRepository.findById(proposal_Id).map(update ->{
            update.setProposalStatus(proposalStatusRepository.findById(status_Id).get());
            return proposalRepository.save(update);
        }).orElseGet(() ->{
            proposal.setId(proposal_Id);
            return proposalRepository.save(proposal);
        });
    }

    @GetMapping("/proposal")
    public Collection<Proposal> getProposal() {
        return proposalRepository.findAll();
    }

    @GetMapping("/getProposalReceiver/{username}")
    public Collection<Proposal> getProposalReceiver(@PathVariable String username) {
        return proposalRepository.findByUserReceiveName(username);
    }

    @GetMapping("/getProposalOffer/{username}/{status_id}")
    public Collection<Proposal> getProposalOffer(@PathVariable String username,@PathVariable long status_id) {
        return proposalRepository.findByUserOfferNameAndProposalStatusOrUserReceiveNameAndProposalStatus(username,proposalStatusRepository.findById(status_id),username,proposalStatusRepository.findById(status_id));
    }

    @GetMapping("/proposalStatus")
    public Collection<ProposalStatus> getProposalStatus() {
        return proposalStatusRepository.findAll();
    }

    @GetMapping("/proposalStatus/{proposalStatus_id}")
    public ProposalStatus getOneProposalStatus(@PathVariable long proposalStatus_id) {
        return proposalStatusRepository.findById(proposalStatus_id);
    }

    @GetMapping("/item")
    public Collection<Item> getItem() {
        return itemRepository.findAll();
    }

    @GetMapping("/item/{user_id}")
    public Collection<Item> getItem(@PathVariable long user_id) {
        return itemRepository.findByUser(userRepository.findById(user_id));
    }

    @GetMapping("/getItemById/{item_id}")
    public Item getOneItem(@PathVariable long item_id) {
        return itemRepository.findById(item_id);
    }

    @GetMapping("/tradeOption")
    public Collection<TradeOption> getTradeOption() {
        return tradeOptionRepository.findAll();
    }

    @GetMapping("/tradeOption/{option_id}")
    public TradeOption getOneTradeOption(@PathVariable long option_id) {
        return tradeOptionRepository.findById(option_id);
    }

    @GetMapping("/user")
    public Collection<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/getUser/{user_id}")
    public User getUser(@PathVariable long user_id) {
        return userRepository.findById(user_id);
    }

    @GetMapping("/getUserByUsername/{username}")
    public User getUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

}

