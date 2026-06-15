package br.com.dio.model;

import br.com.dio.annotation.SerializerType;

import java.io.Serializable;

@SerializerType

public record User(
        long id,
        String fullName,
        int age,
        double salary){

}
