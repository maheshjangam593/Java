package com.example.DBOperations;

import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {EmpControllerTest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmpControllerTest {

    @Test
    @Order(2)
    void getAllEmploye() throws JSONException {
        String expected="[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"deptName\": \"Prem1\",\n" +
                "        \"age\": 20,\n" +
                "        \"deptId\": 1,\n" +
                "        \"department\": null\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"deptName\": \"prem2\",\n" +
                "        \"age\": 25,\n" +
                "        \"deptId\": 2,\n" +
                "        \"department\": null\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"deptName\": \"prem3\",\n" +
                "        \"age\": 30,\n" +
                "        \"deptId\": 2,\n" +
                "        \"department\": null\n" +
                "    }\n" +
                "]";

        TestRestTemplate testRestTemplate=new TestRestTemplate();

        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:9092/getAllEmploye", String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        JSONAssert.assertEquals(expected,response.getBody(),false);


    }
    @Test
    @Order(1)
    void getEmpById() throws JSONException {
        String expected="{\n" +
                "    \"id\": 1,\n" +
                "    \"deptName\": \"Prem1\",\n" +
                "    \"age\": 20,\n" +
                "    \"deptId\": 1,\n" +
                "    \"department\": null\n" +
                "}";
        TestRestTemplate testRestTemplate=new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:9092/emp/1", String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        JSONAssert.assertEquals(expected,response.getBody(),false);

    }

    @Test
    @Order(3)
    void addEmployee() throws JSONException {
        Employee emp=new Employee(4,"raja",30,1,null);
        String expected="{\n" +
                "    \"id\": 4,\n" +
                "    \"deptName\": \"raja\",\n" +
                "    \"age\": 30,\n" +
                "    \"deptId\": 1,\n" +
                "    \"department\": null\n" +
                "}";
        TestRestTemplate testRestTemplate=new TestRestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity httpEntity=new HttpEntity(emp,headers);
        ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:9092/addEmployee", httpEntity, String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        JSONAssert.assertEquals(expected,response.getBody(),false);
    }
    @Test
    @Order(4)
    void updateEmployee() throws JSONException {
        Employee emp=new Employee(4,"raja",33,3,null);
        String expected="{\n" +
                "    \"id\": 4,\n" +
                "    \"deptName\": \"raja\",\n" +
                "    \"age\": 33,\n" +
                "    \"deptId\": 3,\n" +
                "    \"department\": null\n" +
                "}";
        TestRestTemplate testRestTemplate=new TestRestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity httpEntity=new HttpEntity(emp,headers);
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:9092/updateEmployee/4", HttpMethod.PUT,httpEntity, String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(expected,response.getBody(),false);
    }
    @Test
    @Order(5)
    void deleteEmployee() throws JSONException {
        Employee emp=new Employee(4,"raja",33,3,null);
        String expected="{\n" +
                "    \"id\": 4,\n" +
                "    \"deptName\": \"raja\",\n" +
                "    \"age\": 33,\n" +
                "    \"deptId\": 3,\n" +
                "    \"department\": null\n" +
                "}";
        TestRestTemplate testRestTemplate=new TestRestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity httpEntity=new HttpEntity(emp,headers);
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:9092/delete/4", HttpMethod.DELETE,httpEntity, String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(expected,response.getBody(),false);
    }
    /*@Test
    void addEmp() {
    }

    @Test
    void getByName() {
    }

    @Test
    void getByAgeBetween() {
    }

    @Test
    void getAgeGreaterThan() {
    }

    @Test
    void getByDept() {
    }

    @Test
    void getByNames() {
    }

    @Test
    void deleteByName() {
    }

    @Test
    void updateById() {
    }*/
}