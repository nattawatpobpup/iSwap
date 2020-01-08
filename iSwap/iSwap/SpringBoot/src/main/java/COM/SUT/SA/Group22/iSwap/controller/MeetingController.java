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
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class MeetingController {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private MeetingStatusRepository meetingStatusRepository;
    @Autowired
    private ProposalRepository proposalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private TimeRepository timeRepository;


    public MeetingController(MeetingStatusRepository meetingstatusRepository,
                             UserRepository userRepository,
                             MeetingRepository meetingRepository,
                             ProposalRepository proposalRepository,
                             ProvinceRepository provinceRepository,
                             TimeRepository timeRepository) {
        this.meetingRepository = meetingRepository;
        this.meetingStatusRepository = meetingstatusRepository;
        this.userRepository = userRepository;
        this.proposalRepository = proposalRepository;
        this.provinceRepository = provinceRepository;
        this.timeRepository = timeRepository;

    }

    //  =================time====================
    @GetMapping("/Times")
    public Collection<Time> Time() { return timeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/newtime/{time}")
    public Time newTime(@RequestBody Time t, @PathVariable String timename){
        t.setTimename(timename);
        return timeRepository.save(t);
    }
    //  =================province====================
//    this.provinceRepository = provinceRepository;


    //  =================MeetingController====================

//    @GetMapping("/Meeting/{user_id}")
//    public Collection <Meeting> Meeting(@PathVariable long user_id) {
//        System.out.println("userID"+user_id);
//        User uid = userRepository.findById(user_id);
//        Collection<Meeting> S =  meetingRepository.findByuser(uid);
//        return S;
//    }
    @GetMapping("/getMeetingReceive/{username}")
    public Collection<Meeting> getReceive(@PathVariable String username){
        return meetingRepository.findByProposalIn(proposalRepository.findByUserReceiveName(username));
    }
    @GetMapping("/getMeetingOffer/{username}")
    public Collection<Meeting> getOffer(@PathVariable String username){
        return meetingRepository.findByProposalIn(proposalRepository.findByUserOfferName(username));
    }


    @PutMapping("/updateMeeting/{meetingId}/{statusId}")
    Meeting update(Meeting m, @PathVariable Long statusId, @PathVariable Long meetingId){

        return meetingRepository.findById(meetingId)
                .map(update ->{
                    update.setMeetingStatus(meetingStatusRepository.findById(statusId).get());
                            return meetingRepository.save(update);
                        }
                ).orElseGet(() ->{
                    m.setId(meetingId);
                    return meetingRepository.save(m);
                });
    }



    @PostMapping("/newmeeting/create/{status_id}/{proposal_id}")
//    @RequestMapping(path="newmeeting", method=RequestMethod.POST,  consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Meeting createMeeting(@RequestBody String dataMeeting,
                                 @PathVariable long status_id,

                                 @PathVariable long proposal_id)throws IOException {
        final String decoded = URLDecoder.decode(dataMeeting, "UTF-8");        // DECODE UTF8
        dataMeeting = decoded;



        Meeting m = new Meeting();

        if(dataMeeting.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(dataMeeting);
            m.setCallOther(actualObj.get("callotherInput").textValue());
            m.setTelephone(actualObj.get("telephoneInput").textValue());
            m.setText(actualObj.get("textInput").textValue());
            m.setProvince(provinceRepository.findByProvincename(actualObj.get("landmarkSelect").textValue()));
            m.setTime(timeRepository.findByTimename(actualObj.get("timeSelect").textValue()));
            String []dataDate = actualObj.get("dateSelect").textValue().split(Pattern.quote("-"));
            String []forD = dataDate[2].split("T");
            int y = Integer.valueOf(dataDate[0]),mm=Integer.valueOf(dataDate[1]),d= Integer.valueOf(forD[0]);
            String []dataTime = actualObj.get("timeSelect").textValue().split(Pattern.quote("."));
            int h = Integer.valueOf(dataTime[0]),mi=Integer.valueOf(dataTime[1]);
            m.setDates(new Date((y-1900),(mm),(d+1),h,mi));
        }

        m.setMeetingStatus(meetingStatusRepository.findById(status_id));
//        m.setUser(userRepository.findById(user_id));
        m.setProposal(proposalRepository.findById(proposal_id));

        return meetingRepository.save(m);
    }
    @GetMapping("/Meetingshow")
    public List<Meeting> Meeting() {
        return meetingRepository.findAll().stream().collect(Collectors.toList());
    }
//    @PostMapping("/newmeetings/create")
//    public void newmeeting(@RequestBody Meeting m){
//        meetingRepository.save(m);
//    }

    //  =================MeetingStatusController====================


    @GetMapping("/status")
    public List<MeetingStatus> getStatus(){
    return meetingStatusRepository.findAll().stream().collect(Collectors.toList());
}
    @GetMapping("/status/{status_id}")
    public MeetingStatus getOneStatus(@PathVariable Long status_id){
        return meetingStatusRepository.findById(status_id).get();
    }

    @PostMapping("/newstatus/{meetingStatus}")
    public MeetingStatus getnewstatus(@PathVariable String meetingStatus){
        MeetingStatus newStatus = new MeetingStatus();
        newStatus.setMeetingStatusName(meetingStatus);
        return meetingStatusRepository.save(newStatus);
    }

    @PostMapping("/newstatus")
    public void newstatus(@RequestBody MeetingStatus newstatus){
        meetingStatusRepository.save(newstatus);
    }

    //  =================UserController====================

    //  =================ProposalController====================


//    @PostMapping("/newproposal/{itemoffer}/{itemreceiver}/{proposalstatus}/{userreceiver}/{useroffer}")
//    public Proposal getnewproposal(@PathVariable String itemoffer,
//                                   @PathVariable String itemreceiver,
//                                   @PathVariable String proposalstatus,
//                                   @PathVariable String userreceiver,
//                                   @PathVariable Long useroffer){
//        Proposal p = new Proposal();
//        User user = userRepository.findById(useroffer).get();
//        p.setItemOffer(itemoffer);
//        p.setItemReceiver(itemreceiver);
//        p.setProposalStatus(proposalstatus);
//        p.setUserReceiver(userreceiver);
//        p.setUser(user);
//        return proposalRepository.save(p);
//    }
//    @PostMapping("/newproposal")
//    public void newProposal(@RequestBody Proposal p){
//        proposalRepository.save(p);
//    }



}