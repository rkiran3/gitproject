package com.example.springbootwebh2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class RadioButtonForm {
    public String selMonth;
    public List<String> months;
}
