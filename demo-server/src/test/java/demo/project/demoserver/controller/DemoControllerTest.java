package demo.project.demoserver.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import demo.project.demoserver.dto.TestDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DemoControllerTest {


    @Test
    public void test(){

        String requestValue = "test";

        RestTemplate restTemplate = new RestTemplate();

    //       TestDto result = restTemplate.postForObject("http://localhost:8081/api/image", new TestDto(requestValue), TestDto.class,new HashMap<>());
       ResponseEntity<TestDto> result2 = restTemplate.postForEntity("http://localhost:8081/api/image",new TestDto(requestValue),TestDto.class);

       // value after passing demo proxy is base 64 encoded
       assertTrue(Base64.isBase64(result2.getBody().getImage()));

       // the encoded value is not test actual is 1234
       assertEquals(requestValue, new String(Base64.decodeBase64(result2.getBody().getImage()), StandardCharsets.UTF_8));


    }


}