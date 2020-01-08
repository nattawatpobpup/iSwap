package COM.SUT.SA.Group22.iSwap.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController {
    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final HashtagRepository hashtagRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final UserRepository userRepository;
	private String dataItem;
    private String categoryname;

    public ItemController(ItemRepository itemRepository, HashtagRepository hashtagRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.hashtagRepository = hashtagRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/Item")
    public Collection<Item> item() {
        return itemRepository.findAll();
    }
    @PostMapping("/item/{typname}/{hashtagName}/{username}")
    public Item newi (@PathVariable String typname, @PathVariable String hashtagName, @PathVariable String username, @RequestBody String dataItem)throws IOException{
    
    final String decoded = URLDecoder.decode(dataItem, "UTF-8");
        dataItem = decoded;
    Item newitem = new Item();
    if(dataItem.charAt(0) == '{'){

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataItem);
        newitem.setItemName( actualObj.get("itemName").textValue());
        newitem.setDescrition( actualObj.get("desrciptionInput").textValue());
        newitem.setImg( actualObj.get("img").textValue());


    // newitem.setItemname(itemname);
}
    newitem.setCategory(categoryRepository.findByCategoryname(typname));
    newitem.setHashtag(hashtagRepository.findByHashtagname(hashtagName));
    newitem.setUser(userRepository.findByUsername(username));
    return itemRepository.save(newitem);}
    
    @DeleteMapping("/item/delete/{itemid}")
    public void deleteItem(@PathVariable long itemid) {
        itemRepository.deleteById(itemid);
    }

}