package com.nt.mobile.controller;

import com.nt.mobile.model.Holiday;
import com.nt.mobile.service.HolidayService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/common")
@AllArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;
    @GetMapping("/holidays")
    public List<Holiday> fetchAllHolidays(){
        return holidayService.fetchAllHolidays();
    }
    @PostMapping("/holiday")
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday){
        return holidayService.createHoliday(holiday);
    }

    @DeleteMapping("/holiday/delete/{holidayId}")
    public ResponseEntity<HttpStatus> deleteHoliday(@PathVariable("holidayId") String holidayId) {
        return holidayService.deleteByHolidayId(holidayId);
    }

}
