package COM.SUT.SA.Group22.iSwap.controller;

import COM.SUT.SA.Group22.iSwap.entity.Hashtag;
import COM.SUT.SA.Group22.iSwap.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HashtagController {
    @Autowired
    private final HashtagRepository hashtagRepository;
    public HashtagController(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    @GetMapping("/Hashtag")
    public Collection<Hashtag> Hashtag() {
        return hashtagRepository.findAll().stream().collect(Collectors.toList());
    }
}
