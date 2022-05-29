package com.safetynet.safetynetalerts.service;


import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.Medicalrecord;
import com.safetynet.safetynetalerts.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataReaderService {

    private static final Logger log = LogManager.getLogger("DataReaderService");

    JSONObject dataObject;
    private List<Person> personList;

    public DataReaderService() {
        JSONParser parser = new JSONParser();

        try {
            dataObject = (JSONObject) parser.parse(new FileReader("src/main/resources/data/dataJson.json")) ;

        }catch ( IOException | ParseException e) {
            System.out.println(e);
        }
    }

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        JSONArray listPerson =(JSONArray) dataObject.get("persons");

        if(listPerson != null && listPerson.size() != 0) {
            for(Object o : listPerson) {
                JSONObject personObject = (JSONObject) o;
                Person person = new Person();

                person.setFirstName((String) personObject.get("firstName"));
                person.setLastName((String) personObject.get("lastName"));
                person.setAddress((String) personObject.get("address"));
                person.setCity((String) personObject.get("city"));
                person.setZip((String) personObject.get("zip"));
                person.setPhone((String) personObject.get("phone"));
                person.setMail((String) personObject.get("email"));

                personList.add(person);
            }
        }

        return personList;
    }

    public List<FireStation> getFirestations() {
        List<FireStation> fireStationList = new ArrayList<>();
        JSONArray listFireStation = (JSONArray) dataObject.get("firestations");

        if(listFireStation != null && listFireStation.size() != 0) {
            for(Object o : listFireStation) {
                JSONObject fireStationObject = (JSONObject) o;
                FireStation fireStation = new FireStation();

                fireStation.setAddress((String) fireStationObject.get("address"));
                fireStation.setStation(Integer.parseInt(fireStationObject.get("station").toString()));

                fireStationList.add(fireStation);
            }
        }

        return fireStationList;
    }

    public List<Medicalrecord> getMedicalRecords() {
        List<Medicalrecord> medicalRecordList = new ArrayList<>();
        JSONArray listMedicalRecord = (JSONArray) dataObject.get("medicalrecords");

        if(listMedicalRecord != null && listMedicalRecord.size() != 0) {
            for(Object o: listMedicalRecord) {
                JSONObject medicalRecordObject = (JSONObject) o;
                Medicalrecord medicalrecord = new Medicalrecord();

                medicalrecord.setFirstName((String) medicalRecordObject.get("firstName"));
                medicalrecord.setLastName((String) medicalRecordObject.get("lastName"));
                medicalrecord.setBirthdate(new Date((String) medicalRecordObject.get("birthdate")));
                medicalrecord.setMedication((List<String>) medicalRecordObject.get("medications"));
                medicalrecord.setAllergie((List<String>) medicalRecordObject.get("allergies"));

                medicalRecordList.add(medicalrecord);
            }
        }

        return medicalRecordList;
    }

}
