package com.nt.mobile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Holiday {
   @Id
    private String holidayId;
    private String date;
    private String occasion;
    private boolean isOptional;
    private String year;

    public Holiday(String holidayId, String date, String occasion, boolean isOptional, String year) {
        this.holidayId = holidayId;
        this.date = date;
        this.occasion = occasion;
        this.isOptional = isOptional;
        this.year = year;
    }

}
