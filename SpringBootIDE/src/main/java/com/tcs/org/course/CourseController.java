package com.tcs.org.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.topic.Topic;

// Creating RESTful API using Spring MVC

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	// Spring GET Requests

	@RequestMapping("/topic/{id}/course")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topic/{topicid}/course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getSingleCourse(id);
	}

	// Spring POST Requests

	@RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/course")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	// Spring PUT or update request

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicid}/course/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicid, @PathVariable String id) {
		course.setTopic(new Topic(topicid, "", ""));
		courseService.updateCourse(course, id);
	}

	// Spring Delete Request
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{topicid}/course/{id}")
	public void deteleCOurse(@PathVariable String id) {
		courseService.deleteCOurse(id);
	}

}
