
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.WithSpan;

@RestController
public class HelloController {

 static final Counter counter = Metrics.counter("test.counter");

@SuppressWarnings("deprecation")
@WithSpan(value = "My Hello Azure Monitoring")
@GetMapping("/")
public String hello() {
	 AttributeKey attributeKey = AttributeKey.stringKey("mycustomdimension");
	 Span.current().setAttribute(attributeKey, "myvalue1");
	 counter.increment();

    return "Hello Azure Monitoring";
}
}