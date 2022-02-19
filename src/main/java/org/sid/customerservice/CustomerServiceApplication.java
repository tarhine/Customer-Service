package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    //Creer l'objet CommandeLineRunner et inserer des donnes au demarrage pour tester
   @Bean
    CommandLineRunner strat(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null,"TARHINE","tarhinereda@gmail.com"));
            customerRepository.save(new Customer(null,"REDA","maloukreda@gmail.com"));
            customerRepository.save(new Customer(null,"DRISS","tarhinedriss@gmail.com"));
            customerRepository.findAll().forEach(c ->{
                System.out.println(c.toString());
            } );
        };
    }
}
