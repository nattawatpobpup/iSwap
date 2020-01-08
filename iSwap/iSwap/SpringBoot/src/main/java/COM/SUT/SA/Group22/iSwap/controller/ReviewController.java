package COM.SUT.SA.Group22.iSwap.controller;

import COM.SUT.SA.Group22.iSwap.repository.*;
import COM.SUT.SA.Group22.iSwap.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@CrossOrigin(origins =  "http://localhost:4200")
public class ReviewController {

    @Autowired     private ReviewRepository reviewRepository;
    @Autowired     private UserRepository userRepository;
    @Autowired     private ProposalRepository proposalRepository;
    @Autowired     private LevelRepository levelRepository;


    ReviewController(ReviewRepository repository){

        this.reviewRepository = repository;
    }

    // Review
    @GetMapping("/review")
    public Collection<Review> getReview(){
        return reviewRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/review/{reviewId}")
    public Review getReviewById(@PathVariable Long reviewId){
        return reviewRepository.findById(reviewId).get();
    }

    @GetMapping("/user/{userId}")
    public User getUserById (@PathVariable Long userId){

        return userRepository.findById(userId).get();
    }


    @GetMapping("//{propId}")
    public Proposal getPropId (@PathVariable Long propId){

        return proposalRepository.findById(propId).get();
    }

    @GetMapping("/levels")
    public Collection<Level> getLevel(){
        return levelRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/level/{levelId}")
    public Level getLevelbyid(@PathVariable Long levelId){
        return levelRepository.findById(levelId).get();
    }

    @PostMapping("/review/create/{user_id}/{level_id}/{propos_id}/{rating}/{comments}")
    public Review createReview(Review r, @PathVariable String comments, @PathVariable Long user_id, @PathVariable Long level_id,
                               @PathVariable int rating, @PathVariable Long propos_id){


        r.setUser(userRepository.findById(user_id).get());
        r.setLevel(levelRepository.findById(level_id).get());
        r.setProposal(proposalRepository.findById(propos_id).get());
        r.setComments(comments);
        r.setRating(rating);
        r.setReviewdate(new Date());
        return this.reviewRepository.save(r);
    }
}