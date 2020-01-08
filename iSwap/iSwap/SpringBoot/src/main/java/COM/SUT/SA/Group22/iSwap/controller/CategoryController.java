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
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
   

    @GetMapping("/Category")
    public Collection<Category> getCategory() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }

 
}
