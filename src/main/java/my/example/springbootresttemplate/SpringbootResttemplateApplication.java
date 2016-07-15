//https://spring.io/guides/gs/consuming-rest/

package my.example.springbootresttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import my.example.springbootresttemplate.quote.Quote;

@SpringBootApplication
public class SpringbootResttemplateApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(SpringbootResttemplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootResttemplateApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		
		System.out.println("Main Spring Boot program");
		
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        
        log.info(quote.toString());
        //Quote{type='success', value=Value{id=1, quote='Working with Spring Boot is like pair-programming with the Spring developers.'}}
        
        log.info(quote.getValue().getQuote());
        //Working with Spring Boot is like pair-programming with the Spring developers.
    }
}
