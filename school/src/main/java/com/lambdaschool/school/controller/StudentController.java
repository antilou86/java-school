package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.ErrorDetails;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.service.StudentService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    // Please note there is no way to add students to course yet!
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private void Log(HttpServletRequest req){
        logger.info(req.getMethod() + " " + req.getRequestURI() + " Accessed");
    }

    // /?sort=name,desc&sort=id,asc&page=0&size=5
    @ApiOperation(value="return all students using paging and sorting", response = Student.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name= "page", dataType = "interger", paramType = "query", value = "results page you want to retrieve"),
            @ApiImplicitParam(name = "size", dataType = "interger", paramType = "query", value = "number of records per page"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). multiple sort criteria are supported.")
    })

    @GetMapping(value = "" +
            "/students", produces = {"application/json"})
    public ResponseEntity<?> listAllStudents(@PageableDefault(page=0, size=5) Pageable pageable, HttpServletRequest req)
    {
        Log(req);
        List<Student> myStudents = studentService.findAll(pageable);
        return new ResponseEntity<>(myStudents, HttpStatus.OK);
    }
    @GetMapping(value = "/allstudents", produces = {"application/json"})
    public ResponseEntity<?> listAllStudentsWithSorting(@PageableDefault(page=0, size=5) Pageable pageable, HttpServletRequest req)
    {
        Log(req);
        List<Student> allStudents = studentService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
    @ApiOperation(value = "Retrieve student by student ID.", response = Student.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "student found", response = Student.class),
            @ApiResponse(code = 404, message = "student not found", response = ErrorDetails.class)
    })
    @GetMapping(value = "/Student/{StudentId}",
                produces = {"application/json"})
    public ResponseEntity<?> getStudentById(
            @ApiParam(value = "student id", required = true, example = "1")
            @PathVariable
                    Long StudentId,
                    HttpServletRequest req)
    {
        Log(req);
        Student r = studentService.findStudentById(StudentId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }


    @GetMapping(value = "/student/namelike/{name}",
                produces = {"application/json"})
    public ResponseEntity<?> getStudentByNameContaining(
            @PathVariable String name,
            HttpServletRequest req  )
    {
        Log(req);
        List<Student> myStudents = studentService.findStudentByNameLike(name);
        return new ResponseEntity<>(myStudents, HttpStatus.OK);
    }

    @ApiOperation(value = "post a new student", notes = "the newly created student will be sent in the location header", response = void.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "student added", response = void.class),
            @ApiResponse(code = 500, message = "issue adding student, check your post syntax", response = ErrorDetails.class)
    })
    @PostMapping(value = "/student",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewStudent(@Valid
                                           @RequestBody
                                                   Student newStudent,
                                           HttpServletRequest req) throws URISyntaxException
    {
        Log(req);
        newStudent = studentService.save(newStudent);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newStudentURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Studentid}").buildAndExpand(newStudent.getStudid()).toUri();
        responseHeaders.setLocation(newStudentURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Updates and returns existing student", response = Student.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student successfully updated", response = Student.class),
            @ApiResponse(code = 500, message = "Error updating the Student", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Student Not Found", response = ErrorDetails.class)
    })
    @PutMapping(value = "/Student/{Studentid}",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> updateStudent(
            @RequestBody
                    Student updateStudent,
            @ApiParam(value = "student id", required = true, example = "1")
            @PathVariable
                    long Studentid,
            HttpServletRequest req)
    {
        Log(req);
        studentService.update(updateStudent, Studentid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a Student based on studentid", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student successfully deleted", response = void.class),
            @ApiResponse(code = 500, message = "Error deleting the Student", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Student Not Found", response = ErrorDetails.class)
    })
    @DeleteMapping(value = "/Student/{Studentid}",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> deleteStudentById(
            @PathVariable
                    long Studentid,
                    HttpServletRequest req) {
        Log(req);
        studentService.delete(Studentid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
