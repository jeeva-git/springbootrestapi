package com.nt.mobile.repository;

import com.nt.mobile.model.Asset;
import com.nt.mobile.model.Holiday;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HolidayRepository extends MongoRepository<Holiday, String> {
    @Override
    void deleteById(String holidayId);
}
