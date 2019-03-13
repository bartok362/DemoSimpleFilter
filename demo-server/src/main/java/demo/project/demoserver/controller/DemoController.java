package demo.project.demoserver.controller;


import demo.project.demoserver.dto.TestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Http Post for Service
    @PostMapping(value = "/api/image")
    public TestDto testMethod(@RequestBody TestDto body){

        System.out.println(body);

        return body;

    }

}
