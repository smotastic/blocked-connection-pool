package com.example.blockedconnectionpool;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
public class Controller {

	@Autowired
	FooRepository fooRepo;

	@GetMapping("/ping")
	public ResponseEntity<StreamingResponseBody> ping() {
		fooRepo.count();
		StreamingResponseBody body = new StreamingResponseBody() {
			
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				outputStream.write("hello".getBytes());
			}
		};
		return ResponseEntity.ok(body);
	}
}
