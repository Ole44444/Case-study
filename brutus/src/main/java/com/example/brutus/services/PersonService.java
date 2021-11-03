package com.example.brutus.services;

import com.example.brutus.Entities.Person;
import com.example.brutus.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void loadDatabaseFromCSV() {
        try {
            String csvFilepath = "src/main/resources/datasett.csv";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilepath));

            // Skip seq,name/first,name/last,age,street,city,state,latitude,longitude,ccnumber
            bufferedReader.readLine();
            String line = null;

            while((line=bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Person person = new Person();

                person.setSeq(Long.parseLong(data[0]));
                person.setFirstName(data[1]);
                person.setLastName(data[2]);
                person.setAge(Long.parseLong(data[3]));
                person.setStreet(data[4]);
                person.setCity(data[5]);
                person.setState(data[6]);
                person.setLatitude(Float.parseFloat(data[7]));
                person.setLongitude(Float.parseFloat(data[8]));
                person.setCcnumber(data[9]);
                personRepository.save(person);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadDatabaseIfEmpty() {
        if(personRepository.count() == 0){
            System.out.println("Loading database...");
            this.loadDatabaseFromCSV();
            System.out.println("Database initialized");
        }
    }
}
