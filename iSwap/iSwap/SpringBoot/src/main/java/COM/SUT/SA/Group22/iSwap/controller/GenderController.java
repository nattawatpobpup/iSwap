package COM.SUT.SA.Group22.iSwap.controller;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GenderController {
    @Autowired
    private final GenderRepository genderRepository;
    public GenderController(GenderRepository genderRepository){this.genderRepository =genderRepository; }

    @GetMapping("/Genders")
    public Collection<Gender> Gender() {
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }
}
