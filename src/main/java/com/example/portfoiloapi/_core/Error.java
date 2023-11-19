package com.example.portfoiloapi._core;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

  private String code;

  private String message;

  private String status;

}
