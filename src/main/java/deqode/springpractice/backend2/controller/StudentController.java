package deqode.springpractice.backend2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import deqode.springpractice.backend2.contants.EResponse;
import deqode.springpractice.backend2.entity.Student;
import deqode.springpractice.backend2.service.StudentService;
import deqode.springpractice.backend2.utility.BaseResponse;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public ResponseEntity<BaseResponse> addStudent(@RequestBody Student stud){
		BaseResponse response = new BaseResponse();
		try {
			Student student = studentService.addStudent(stud);
			response.setResponseCode(EResponse.SUCCESS.getCode());
			response.setResponseMessage(EResponse.SUCCESS.getMessage());
			response.setResponseBody(student);
		} catch (Exception e) {
			response.setResponseCode(EResponse.FAILED.getCode());
			response.setResponseMessage(EResponse.FAILED.getMessage());
			response.setResponseBody(e.getMessage());

		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getstudent")
	public ResponseEntity<BaseResponse> getStudent(){
		BaseResponse response = new BaseResponse();
		try {
			List<Student> student = studentService.getStudent();
			response.setResponseCode(EResponse.SUCCESS.getCode());
			response.setResponseMessage(EResponse.SUCCESS.getMessage());
			response.setResponseBody(student);
		} catch (Exception e) {
			response.setResponseCode(EResponse.FAILED.getCode());
			response.setResponseMessage(EResponse.FAILED.getMessage());
			response.setResponseBody(e.getMessage());

		}
		return ResponseEntity.ok(response);
	}
}
