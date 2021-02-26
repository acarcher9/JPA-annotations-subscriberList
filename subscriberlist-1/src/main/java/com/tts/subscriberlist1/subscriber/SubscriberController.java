package com.tts.subscriberlist1.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller lets Spring know what this class is
@Controller
public class SubscriberController {

	@Autowired
	private SubscriberRepository subscriberRepository;

//	value="/" is setting the homepage (localhost:8080/). The return statement indicates that our index.html is the what the "/" displays
	@GetMapping(value = "/")
	public String index(Subscriber subscriber) {
		return "subscriber/index";
	}

	private Subscriber subscriber;

	@PostMapping(value = "/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
		
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("userName", subscriber.getUserName());
		return "subscriber/result";
	}

}
