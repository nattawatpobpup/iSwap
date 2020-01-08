package COM.SUT.SA.Group22.iSwap.controller;

import java.util.regex.Pattern;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private ProvinceRepository provinceRepository;
    private CareerRepository careerRepository;
    private GenderRepository genderRepository;

    public UserController(UserRepository userRepository ,ProvinceRepository provinceRepository,
                          CareerRepository careerRepository,GenderRepository genderRepository) {
        this.userRepository = userRepository;
        this.provinceRepository = provinceRepository;
        this.careerRepository = careerRepository;
        this.genderRepository = genderRepository;
    }

    @PostMapping("/Regis/{gendertype}/{careername}/{provincename}/{brithday}")
    public User newnameUser(@PathVariable String gendertype,@PathVariable String careername,@PathVariable String provincename,
                            @PathVariable Date brithday,
                            @RequestBody String dataUser
                            ) throws IOException {
        final String decoded = URLDecoder.decode(dataUser, "UTF-8");
        dataUser = decoded;

        User newUser = new User();

        if(dataUser.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(dataUser);
            newUser.setFirstname( actualObj.get("firstnameInput").textValue());
            newUser.setLastname( actualObj.get("lastnameInput").textValue());
            newUser.setUsername(actualObj.get("usernameInput").textValue());
            newUser.setPassword( actualObj.get("passwordInput").textValue());
            newUser.setAddress( actualObj.get("addressInput").textValue());
            newUser.setPostcode( actualObj.get("postcodeInput").textValue());
            newUser.setPhonenum( actualObj.get("phonenumInput").textValue());

        }
        newUser.setBrithday(brithday);
        newUser.setUserProvince(provinceRepository.findByProvincename(provincename));
        newUser.setUserGender(genderRepository.findByGendertype(gendertype));
        newUser.setUserCareer(careerRepository.findByCareername(careername));

        return userRepository.save(newUser);
    }

    @GetMapping("/Users")
    public Collection<User> User() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/User/{userid}")
    public User User(@PathVariable long userid) {
        return userRepository.findById(userid);
    }
}
