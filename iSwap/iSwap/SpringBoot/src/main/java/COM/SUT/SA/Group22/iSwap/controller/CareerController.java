package COM.SUT.SA.Group22.iSwap.controller;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CareerController {
    @Autowired
    private final CareerRepository careerRepository;
    public CareerController(CareerRepository careerRepository) {this.careerRepository = careerRepository; }

//    @PostMapping("/AddCar/{careername}")
//    public Career newnameCareer(@PathVariable String careername){
//        Career newCareer = new Career();
//        newCareer.setCareername(careername);
//        return careerRepository.save(newCareer); // บันทึก Objcet ชื่อ user
//    }


    @GetMapping("/Careers")
    public Collection<Career> Career() { return careerRepository.findAll().stream().collect(Collectors.toList());
    }

}
