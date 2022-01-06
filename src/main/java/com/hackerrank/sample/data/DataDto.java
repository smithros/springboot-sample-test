package com.hackerrank.sample.data;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDto implements Serializable {
    private Long id;
    private Date date;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
}
