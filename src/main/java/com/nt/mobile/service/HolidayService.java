package com.nt.mobile.service;

import com.nt.mobile.model.Asset;
import com.nt.mobile.model.Holiday;
import com.nt.mobile.repository.HolidayRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;

    public List<Holiday> fetchAllHolidays(){
        return holidayRepository.findAll();
    }
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) {
        try{
            Holiday _holiday = holidayRepository.save(
                    new Holiday(
                            holiday.getHolidayId(),
                            holiday.getDate(),
                            holiday.getOccasion(),
                            holiday.isOptional(),
                            holiday.getYear()
                            )
            );
            return new ResponseEntity<>(_holiday, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus>deleteByHolidayId(String holidayId){
           try{
               holidayRepository.deleteById(holidayId);
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }
}