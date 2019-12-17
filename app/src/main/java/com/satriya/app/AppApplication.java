package com.satriya.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satriya.app.entity.Shape;
import com.satriya.app.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AppApplication {

	@Autowired
	private ShapeRepository shapeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
