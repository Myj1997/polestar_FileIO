package com.polestar.json;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        JsonTask jsonTask = new JsonTask();
        jsonTask.jsonWrite("jsonTask.json");

        //파일 읽기
        jsonTask.jsonReader("jsonTask.json");

    }
}
