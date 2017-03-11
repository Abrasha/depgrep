package com.github.abrasha.depgrep;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.abrasha.depgrep.web.dto.maven.MavenCentralSearchResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;


class Response {
    Long uid;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    int hidden;
    
    public Long getUid() {
        return uid;
    }
    
    public void setUid(Long uid) {
        this.uid = uid;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getHidden() {
        return hidden;
    }
    
    public void setHidden(int hidden) {
        this.hidden = hidden;
    }
}

class VkResponse {
    List<Response> response;
    
    public List<Response> getResponse() {
        return response;
    }
    
    public void setResponse(List<Response> response) {
        this.response = response;
    }
}

/**
 * @author Andrii Abramov on 3/11/17.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        RestTemplate restTemplate = new RestTemplate();
        
        itDoesntWOrk(restTemplate);
    
//        itWorks(restTemplate);
    }
    
    private static void itDoesntWOrk(RestTemplate restTemplate) {
        ResponseEntity<MavenCentralSearchResponse> response = restTemplate.getForEntity("http://search.maven.org/solrsearch/select?wt=json&rows=20&q=guice", MavenCentralSearchResponse.class);
        
        System.out.println(response);
        System.out.println(response.getStatusCode());
        System.out.println(response.hasBody());
        System.out.println(response.getBody().getMavenResponse());
    }
    
    private static void itWorks(RestTemplate restTemplate) {
        ResponseEntity<VkResponse> response = restTemplate.getForEntity("https://api.vk.com/method/users.get?uids=abramov.andrii", VkResponse.class);
        
        System.out.println(response);
        System.out.println(response.getStatusCode());
        System.out.println(response.hasBody());
        System.out.println(response.getBody().getResponse());
        System.out.println(response.getBody().getResponse().get(0));
        System.out.println(response.getBody().getResponse().get(0).getFirstName());
    }
}