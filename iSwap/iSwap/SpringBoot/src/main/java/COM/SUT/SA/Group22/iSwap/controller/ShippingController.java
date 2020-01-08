package COM.SUT.SA.Group22.iSwap.controller;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ShippingController {

    @Autowired private ShippingRepository shippingRepository;
    @Autowired private ShippingStatusRepository shippingStatusRepository;
    @Autowired private ProposalRepository proposalRepository;
    @Autowired private ProvinceRepository provinceRepository;

    @Autowired
    public ShippingController(ShippingRepository shippingRepository,
                              ShippingStatusRepository shippingStatusRepository,
                              ProposalRepository proposalRepository,
                              ProvinceRepository provinceRepository){
        this.shippingRepository = shippingRepository;
        this.shippingStatusRepository = shippingStatusRepository;
        this.proposalRepository = proposalRepository;
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/Shipping")
    public Collection<Shipping> Shipping(){
        return shippingRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Shipping/{shippingID}")
    public Optional<Shipping> Shipping(@PathVariable Long shippingID){
        return shippingRepository.findById(shippingID);
    }

    @GetMapping("/Province")
    public  Collection<Province> Province(){
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Province/{provinceID}")
    public  Optional<Province> Province(@PathVariable Long provinceID){
        return provinceRepository.findById(provinceID);
    }

    @GetMapping("/ShippingStatus")
    public  Collection<ShippingStatus> ShippingStatus(){
        return shippingStatusRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/ShippingStatus/{statusID}")
    public  Optional<ShippingStatus> ShippingStatus(@PathVariable Long statusID){
        return shippingStatusRepository.findById(statusID);
    }


    @PostMapping("/newShipping/{province_id}/{shippingstatus_id}/{shippingdate}/{proposal_id}")
    public Shipping newShipping(@PathVariable long province_id,@PathVariable long proposal_id,
                                @PathVariable long shippingstatus_id,@PathVariable Date shippingdate,
                                @RequestBody String dataShipping)throws IOException {

        Shipping newShipping = new Shipping();

        final String decode = URLDecoder.decode(dataShipping, "UTF-8");
        dataShipping = decode;

        if(dataShipping.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(dataShipping);
            newShipping.setShipper(actualObj.get("shipperInput").textValue());
            newShipping.setReceiver(actualObj.get("receiverInput").textValue());
            newShipping.setAddress(actualObj.get("addressInput").textValue());
            newShipping.setPostcode(actualObj.get("postcodeInput").textValue());
            newShipping.setTrackingNo(actualObj.get("trackingNoInput").textValue());
            newShipping.setAgency(actualObj.get("agencyInput").textValue());
        }

        newShipping.setShippingProposal(proposalRepository.findById(proposal_id));
        newShipping.setDate(shippingdate);
        newShipping.setShippingProvince(provinceRepository.findById(province_id));
        newShipping.setShippingStatus(shippingStatusRepository.findById(shippingstatus_id));

        return shippingRepository.save(newShipping);
    }

    @PutMapping("/updateShipping/{shipping_id}/{status_id}")
    Shipping update(Shipping S, @PathVariable Long shipping_id, @PathVariable Long status_id) {

        return shippingRepository.findById(shipping_id).map(update -> {
                    update.setShippingStatus(shippingStatusRepository.findById(status_id).get());
                    return shippingRepository.save(update);
        }).orElseGet(() -> {
                S.setId(shipping_id);
                return shippingRepository.save(S);
        });
    }

}
