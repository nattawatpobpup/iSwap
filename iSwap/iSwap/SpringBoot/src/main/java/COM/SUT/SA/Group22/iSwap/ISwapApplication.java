package COM.SUT.SA.Group22.iSwap;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import java.util.stream.Stream;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ISwapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ISwapApplication.class, args);
	}

	String []typeOfGender = {"ไม่ระบุ","ชาย","หญิง","อืนๆ"};
    String []nameOfCareer = {"นักศึกษา","ข้าราชการ","ฟรีแลนซ์","ครูอาจารย์","อืนๆ"};
    String []nameOfProvince = {"กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี",
            "ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช",
            "นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา","พังงา",
            "พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พะเยา","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน","ยะลา","ยโสธร",
            "ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา","สตูล","สมุทรปราการ",
            "สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี","สุรินทร์","หนองคาย","หนองบัวลำภู",
            "อ่างทอง","อุดรธานี","อุทัยธานี","อุตรดิตถ์","อุบลราชธานี","อำนาจเจริญ"};
    String []nameOfProposalStatus = {"รอการตอบรับ", "ยอมรับ", "ปฏิเสธ"};
    String []nameOfTradeOption = {"นัดรับ", "จัดส่ง"};
    String []nameOfCategory = {"เสื้อผ้าและแฟชั่น","อุปกรณ์อิเล็กทรอนิกส์","เครื่องใช้ภายในบ้าน","เครื่องประดับ","ยานยนต์","อุปกรณ์กีฬา"};
	String []nameOfHashtag = {"ของแท้","เครื่องใช้ไฟฟ้า","มือถือ","แลปท็อป","แต่งรถยนต์","แต่งรถมอเตอร์ไซค์","คอมพิวเตอร์"};
	String []nameOfShippingStatus = {"จัดส่งสินค้าแล้วอยู่ระหว่างการขนย้าย", "ได้รับสิ้นค้าแล้ว"};
	String []Time = {

			"06.00",
			"06.30",
			"07.00",
			"07.30",
			"08.00",
			"08.30",
			"09.00",
			"09.30",
			"10.00",
			"10.30",
			"11.00",
			"11.30",
			"12.00",
			"12.30",
			"13.00",
			"13.30",
			"14.00",
			"14.30",
			"15.00",
			"15.30",
			"16.00",
			"16.30",
			"17.00",
			"17.30",
			"18.00",
			"18.30",
			"19.00",
			"19.30",
			"20.00",
			"20.30",
			"21.00",
			"21.30",
			"22.00",
			"22.30",
			"23.00",
			"23.30" };
	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository,
						   ProposalRepository proposalRepository,
						   ProposalStatusRepository proposalStatusRepository,
						   ItemRepository itemRepository,
						   TradeOptionRepository tradeOptionRepository,
						   ProvinceRepository provinceRepository,
						   CareerRepository careerRepository,
						   GenderRepository genderRepository,
						   HashtagRepository hashtagRepository,
						   CategoryRepository categoryRepository,
						   ReviewRepository reviewRepository,
						   ShippingRepository shippingRepository,
						   ShippingStatusRepository shippingStatusRepository,
						   MeetingRepository meetingRepository,
						   MeetingStatusRepository meetingstatusRepository,
						   TimeRepository timeRepository,
						   LevelRepository levelRepository
						   ) {
	    return args -> {
			Stream.of(nameOfProposalStatus).forEach(statusName -> {
				proposalStatusRepository.save(new ProposalStatus(statusName));});
			Stream.of(nameOfTradeOption).forEach(optionName -> {
				tradeOptionRepository.save(new TradeOption(optionName));});
			Stream.of(nameOfProvince).forEach(provinceName -> {
				provinceRepository.save(new Province(provinceName));});
			Stream.of(typeOfGender).forEach(GenderType -> {
				genderRepository.save(new Gender(GenderType));});
			Stream.of(nameOfCareer).forEach(Careername -> {
			    careerRepository.save(new Career(Careername));});
			Stream.of(nameOfCategory).forEach(categoryname ->{
				categoryRepository.save(new Category(categoryname));});
			Stream.of(nameOfHashtag).forEach(hashtagname -> {
				hashtagRepository.save(new Hashtag(hashtagname));});
			Stream.of(nameOfShippingStatus).forEach(shippingStatusName -> {
				shippingStatusRepository.save(new ShippingStatus(shippingStatusName));});
			Stream.of(Time).forEach(timeName -> {
				Time time = new Time ();
				time.setTimename(timeName);
				timeRepository.save(time);
			});
			Stream.of("ยังไม่ได้แลก","แลกเปลี่ยนเรียบร้อย").forEach(statusName -> {
				MeetingStatus meetingstatus = new MeetingStatus();
				meetingstatus.setMeetingStatusName(statusName);
				meetingstatusRepository.save(meetingstatus);
			});


			userRepository.save(new User("สมชาย","ครบตระกูล","test01","1234",new Date(1,2,3),"77/391",
                    "24120","0970050371",provinceRepository.findById(1),
                    careerRepository.findById(1),genderRepository.findById(1)));
			userRepository.save(new User("สมหมาย","ครบตระกูล","test02","2345",new Date(1,2,3),"77/391",
                    "24120","0970050372",provinceRepository.findById(2),
                    careerRepository.findById(2),genderRepository.findById(2)));
			userRepository.save(new User("สมคิด","ครบตระกูล","test03","3456",new Date(1,2,3),"77/391",
                    "24120","0970050373",provinceRepository.findById(3),
                    careerRepository.findById(3),genderRepository.findById(4)));
			userRepository.save(new User("สมควร","ครบตระกูล","test04","4567",new Date(1,2,3),"77/391",
                    "24120","0970050374",provinceRepository.findById(4),
                    careerRepository.findById(4),genderRepository.findById(3)));
            userRepository.save(new User("สมศักดิ์","ครบตระกูล","test05","5678",new Date(1,2,3),"77/391",
                    "24120","0970050375",provinceRepository.findById(10),
                    careerRepository.findById(5),genderRepository.findById(2)));

			Item item = new Item();
			item.setItemName("Computer");
			item.setUser(userRepository.findById(1));
			item.setImg("https://www.img.in.th/images/e9c996c2b413b5e6d734be486dc4e2d2.jpg");
			item.setCategory(categoryRepository.findById(2));
			item.setHashtag(hashtagRepository.findById(7));
			item.setDescrition("คอมพิวเตอร์ประกอบมือสอง");
			itemRepository.save(item);

			Item item2 = new Item();
			item2.setItemName("Samsung Galaxy G6");
			item2.setUser(userRepository.findById(2));
			item2.setImg("https://www.img.in.th/images/dfb6cd914ba7db3488c02622d3173c93.jpg");
			item2.setCategory(categoryRepository.findById(2));
			item2.setHashtag(hashtagRepository.findById(7));
			item2.setDescrition("Galaxy A6 2018 ใช้งาน2เดือน");
			itemRepository.save(item2);

			Item item3 = new Item();
			item3.setItemName("หม้อหุงข้าวไฟฟ้า");
			item3.setUser(userRepository.findById(3));
			item3.setImg("https://www.img.in.th/images/e907f7c53efd364350bf881e29ce80e8.jpg");
			item3.setCategory(categoryRepository.findById(3));
			item3.setHashtag(hashtagRepository.findById(2));
			item3.setDescrition("หม้อหุงข้าวไฟฟ้าใช้งาน1เดือน");
			itemRepository.save(item3);

			Item item4 = new Item();
			item4.setItemName("ยางรถยยต์");
			item4.setUser(userRepository.findById(4));
			item4.setImg("https://www.img.in.th/images/ef2372e75c57cc2fb528ab27e342440e.jpg");
			item4.setCategory(categoryRepository.findById(5));
			item4.setHashtag(hashtagRepository.findById(5));
			item4.setDescrition("ยางรถยนต์ซื้อมาผิด");
			itemRepository.save(item4);

			Item item5 = new Item();
			item5.setItemName("นาฬิกาCASIO");
			item5.setUser(userRepository.findById(5));
			item5.setImg("https://www.img.in.th/images/bbd5b80b86e29c1630df04ab947b8401.jpg");
			item5.setCategory(categoryRepository.findById(1));
			item5.setHashtag(hashtagRepository.findById(1));
			item5.setDescrition("CASIO");
			itemRepository.save(item5);

			Item item6 = new Item();
			item6.setItemName("Nike Jordan 1 High");
			item6.setUser(userRepository.findById(5));
			item6.setImg("https://www.img.in.th/images/1e6e1f2ee8443065966afc330639328a.jpg");
			item6.setCategory(categoryRepository.findById(1));
			item6.setHashtag(hashtagRepository.findById(1));
			item6.setDescrition("Nike Jordan 1 High");
			itemRepository.save(item6);

			Item item7 = new Item();
			item7.setItemName("Nike Air Max 95");
			item7.setUser(userRepository.findById(4));
			item7.setImg("https://www.img.in.th/images/7b4158d2a7945ad1540f5f5073db7358.png");
			item7.setCategory(categoryRepository.findById(1));
			item7.setHashtag(hashtagRepository.findById(1));
			item7.setDescrition("Nike Air Max 95");
			itemRepository.save(item7);

			Item item8 = new Item();
			item8.setItemName("ยางรถยยต์");
			item8.setUser(userRepository.findById(3));
			item8.setImg("https://www.img.in.th/images/b778726194ca9faf25df2b18098b2358.jpg");
			item8.setCategory(categoryRepository.findById(4));
			item8.setHashtag(hashtagRepository.findById(1));
			item8.setDescrition("สร้อยกางเขน");
			itemRepository.save(item8);

			Item item9 = new Item();
			item9.setItemName("กระจกรถยนต์");
			item9.setUser(userRepository.findById(2));
			item9.setImg("https://www.img.in.th/images/8a85ebb306d0f08253ca64b1553312dd.jpg");
			item9.setCategory(categoryRepository.findById(5));
			item9.setHashtag(hashtagRepository.findById(6));
			item9.setDescrition("กระจกรถมอเตอร์ไซต์สภาพดี");
			itemRepository.save(item9);

			Item item10 = new Item();
			item10.setItemName("Nile Lebron 13");
			item10.setUser(userRepository.findById(1));
			item10.setImg("https://www.img.in.th/images/24a81777948b15cba109e8908d62cb91.jpg");
			item10.setCategory(categoryRepository.findById(6));
			item10.setHashtag(hashtagRepository.findById(1));
			item10.setDescrition("Nike Lebron13 Size41");
			itemRepository.save(item10);

			proposalRepository.save(new Proposal(itemRepository.findById(1),itemRepository.findById(2),tradeOptionRepository.findById(1),
                    "ของใช้มา6เดือนแล้วครับ",proposalStatusRepository.findById(1)));
			proposalRepository.save(new Proposal(itemRepository.findById(3),itemRepository.findById(4),tradeOptionRepository.findById(2),
                    "เพิ่มให้อีก200บ.",proposalStatusRepository.findById(1)));
			proposalRepository.save(new Proposal(itemRepository.findById(1),itemRepository.findById(3),tradeOptionRepository.findById(1),
					"ของใช้มา6เดือนแล้วครับ",proposalStatusRepository.findById(1)));
			proposalRepository.save(new Proposal(itemRepository.findById(3),itemRepository.findById(4),tradeOptionRepository.findById(2),
					"เพิ่มให้อีก200บ.",proposalStatusRepository.findById(1)));
			proposalRepository.save(new Proposal(itemRepository.findById(5),itemRepository.findById(6),tradeOptionRepository.findById(1),
					"ของพึ่งใช้ได้ครั้งเดียวเอง.",proposalStatusRepository.findById(1)));
			proposalRepository.save(new Proposal(itemRepository.findById(7),itemRepository.findById(8),tradeOptionRepository.findById(1),
					"เพิ่มให้อีก2000บาทนะ.",proposalStatusRepository.findById(1)));
			proposalRepository.save(new Proposal(itemRepository.findById(9),itemRepository.findById(10),tradeOptionRepository.findById(1),
					"สภาพใหม่เอี่ยมเค่ะ.",proposalStatusRepository.findById(1)));

			Date D = new Date((2018-1900),(2-1),3);
			Date D1 = new Date((2018-1900),(3-1),27);
			Date D2 = new Date((2018-1900),(4-1),13);

			shippingRepository.save(new Shipping(proposalRepository.findById(1).getUserOfferName(),proposalRepository.findById(1).getUserReceiveName(),D,"213/551","30000","EVS0123456789","ปณ.นครราชสีมา",shippingStatusRepository.findById(2),provinceRepository.findById(21),proposalRepository.findById(1)));
			shippingRepository.save(new Shipping(proposalRepository.findById(2).getUserOfferName(),proposalRepository.findById(2).getUserReceiveName(),D1,"123/7","40000","EVS0123451234","ปณ.ขอนแก่น",shippingStatusRepository.findById(1),provinceRepository.findById(6),proposalRepository.findById(2)));
			shippingRepository.save(new Shipping(proposalRepository.findById(3).getUserOfferName(),proposalRepository.findById(3).getUserReceiveName(),D2,"42/235","30000","EVS0123454321","ปณ.นครราชสีมา",shippingStatusRepository.findById(1),provinceRepository.findById(21),proposalRepository.findById(3)));

			Meeting	meeting1 = new Meeting();
			meeting1.setDates(new Date((2018-1900),2,3));
			meeting1.setText("หน้าเว่น มทส.ประตู1");
			meeting1.setTelephone("0912345678");
			meeting1.setCallOther("Facebook:สมชาย");
			meeting1.setProvince(provinceRepository.findById(1));
			meeting1.setMeetingStatus(meetingstatusRepository.findById(1));
			meeting1.setProposal(proposalRepository.findById(1));
			meeting1.setTime(timeRepository.findById(3));
			meetingRepository.save(meeting1);


			Meeting	meeting2 = new Meeting();
			meeting2.setDates(new Date((2018-1900),2,3));
			meeting2.setProvince(provinceRepository.findById(50));
			meeting2.setCallOther("Facebook:สมหมมาย");
			meeting2.setTelephone("02334455656");
			meeting2.setText("หน้าเว่น มทส.ประตู4");
			meeting2.setMeetingStatus(meetingstatusRepository.findById(1));
			meeting2.setProposal(proposalRepository.findById(2));
			meeting2.setTime(timeRepository.findById(8));
			meetingRepository.save(meeting2);

			Level lv1 = new Level();
			lv1.setLevelname("ดี");
			levelRepository.save(lv1);

			Level lv2 = new Level();
			lv2.setLevelname("ปานกลาง");
			levelRepository.save(lv2);

			Level lv3 = new Level();
			lv3.setLevelname("ต่ำ");
			levelRepository.save(lv3);

			Review rat = new Review();
			rat.setUser(userRepository.findById(1));
			rat.setLevel(levelRepository.findById(1));
			rat.setProposal(proposalRepository.findById(1));
			rat.setRating(5);
			rat.setComments("So good");
			rat.setReviewdate(new Date());
			reviewRepository.save(rat);

			Review rat1 = new Review();
			rat1.setUser(userRepository.findById(2));
			rat1.setLevel(levelRepository.findById(1));
			rat1.setProposal(proposalRepository.findById(2));
			rat1.setRating(3);
			rat1.setComments("Very nice,I love it");
			rat1.setReviewdate(new Date());
			reviewRepository.save(rat1);
		};
	}
}