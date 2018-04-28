package com.tcs.org.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Creating RESTful API using Spring MVC

@RestController
public class TopicController {

	@Autowired
	private TopicService topicservice;

	// Spring GET Requests

	@RequestMapping("/topic")
	public List<Topic> getAllTopics() {
		return topicservice.getAllTopics();
	}

	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getSingleTipic(id);
	}

	// Spring POST Requests

	@RequestMapping(method = RequestMethod.POST, value = "/topic")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addtopic(topic);
	}

	// Spring PUT or update request

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicservice.updateTopic(topic, id);
	}

	// Spring Delete Request
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{id}")
	public void deteleTopic(@PathVariable String id) {
		topicservice.deleteTopic(id);
	}

}
