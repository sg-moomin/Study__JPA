package com.heejea.simple.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.heejea.simple.entity.*;
import com.heejea.simple.repository.blogPostRepository;
import com.heejea.simple.repository.myServiceRepository;
import com.heejea.simple.repository.noticeboardRepository;
import com.heejea.simple.repository.projectRepository;
import com.heejea.simple.svc.blogPostEntityService;
import com.heejea.simple.svc.myServiceEntityService;
import com.heejea.simple.svc.profileEntityService;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Controller
@RestController	
@RequiredArgsConstructor
public class mainController {

	private projectRepository pRepository;
	private noticeboardRepository nRepository;
	private myServiceRepository myRepository;
	private blogPostRepository blogPostRepository;
	
	
	@Autowired
	public profileEntityService profileEntitySvc;
	
	@Autowired
	public myServiceEntityService myServiceEntitySvc;
	

	@Autowired
	public blogPostEntityService blogPostEntitySvc;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView M) {
		
		
		List<noticeboardEntity> result = profileEntitySvc.mainInit();
		M.addObject("main", result);
		M.setViewName("index");
		return M;
	}

	@RequestMapping(value="/blogDetail", method=RequestMethod.GET)
	public ModelAndView blogDetail(ModelAndView M) {
		System.out.println("blogDetail page");
		M.setViewName("blogDetail");
		
		return M;
	}
	
	@RequestMapping(value="/blogDetail", method=RequestMethod.POST)
	public ModelAndView blogDetail(@RequestParam Map<String, Object> param, ModelAndView M){
		System.out.println("Map test : " + param.toString());
		//		System.out.print("test : " + deleteNumber);
		System.out.println("blogDetail page");
		M.setViewName("blogDetail");
		
		return M;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView M) {
		
		System.out.println("login page");
		M.setViewName("login");
		
		return M;
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public ModelAndView about(ModelAndView M) {
		
		System.out.println("home page");
		M.setViewName("about");
		
		return M;
	}
	
	@RequestMapping(value="/blog", method=RequestMethod.POST)
	public ModelAndView blog(ModelAndView M, @RequestParam Map<String, Object> param) {
		System.out.println("blog test : " + param.toString());
		M.setViewName("blogDetail");
		
		return M;
	}
	
	@RequestMapping(value="/blog", method=RequestMethod.GET)
	public ModelAndView blog(ModelAndView M) {
		
		System.out.println("blog page");
		M.setViewName("blog");
		
		return M;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/blogPost", method=RequestMethod.GET)
	public ModelAndView blogPost(ModelAndView M, String findPostId) {
			
		// List<blogPostEntity> result = blogPostEntitySvc.init();
		List<blogPostEntity> result = blogPostEntitySvc.searchFindId(findPostId);
		List<blogPostEntity> titles = blogPostEntitySvc.findByPostMainTitle();
	
		for(blogPostEntity post : titles) {
			System.out.println("JPA Querey Test [postId] ::: " + post.getPostid());
			System.out.println("JPA Querey Test [postMainTitle] ::: " + post.getPostmaintitle());
			System.out.println("JPA Querey Test [postSnTitle] ::: " + post.getPostsntitle());
			System.out.println("JPA Querey Test [postSn] ::: " + post.getPostsn());
			System.out.println("JPA Querey Test [postUrl] ::: " + post.getPosturl());
			
		}
		
		M.addObject("myPost", result);
		M.setViewName("blogPost");
		
		
		return M;
	}
	
	
	@RequestMapping(value="/collection", method=RequestMethod.GET)
	public ModelAndView collection(ModelAndView M) {
		
		System.out.println("collection page");
		M.setViewName("collection");
		
		return M;
	}
	
	@RequestMapping(value="/services", method=RequestMethod.GET)
	public ModelAndView services(ModelAndView M) {
		
		List<myServiceEntity> result =  myServiceEntitySvc.init();
		
		M.addObject("myService", result);
		M.setViewName("services");
		return M;

	
	}
	

	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public ModelAndView contact(ModelAndView M) {
		
		System.out.println("contact page");
		M.setViewName("contact");
		
		return M;
	}
	

	@RequestMapping(value="/single", method=RequestMethod.GET)
	public ModelAndView single(ModelAndView M) {
		
		System.out.println("single page");
		M.setViewName("single");
		
		return M;
	}
	
	
//	@GetMapping("profile")
//	public List<profileEntity> findAll(){
//		System.out.println("helllllllo");
//		System.out.println(pRepository.count());
//		List<profileEntity> result =  pRepository.findAll();
//		System.out.println(
//			"PID : " + result.get(0).getPid() +
//			"| Name : " + result.get(0).getName() +
//			"| userName : " + result.get(0).getUsername()
//		);
//		return result;
//	}
//	
//	
//	@PostMapping("profile")
//	public profileEntity startSetUp() {
//		final profileEntity profile = profileEntity.builder()
//					.username("sg-moomin-tistory")
//					.name("sgmoomins")
//					.build();
//		return pRepository.save(profile);
//	}
}
