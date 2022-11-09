package com.dgsoft.conversion.component.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestObject {
    private int number;
    private String message;
    private boolean decision;
}
