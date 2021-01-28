package com.team4.employeemood;

import com.team4.employeemood.model.Mail;
import com.team4.employeemood.service.EmailSenderService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Log4j2
class EmployeemoodApplicationTests {

	@Autowired
	EmailSenderService senderService;

	@Test
	void contextLoads() throws IOException, MessagingException {
		log.info("sending sample email");

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("name", "John Michel!");
		properties.put("location", "Sri Lanka");
		properties.put("sign", "Java Developer");

		Mail mail = Mail.builder()
				.from("catalingheorghe111@gmail.com")
				.to("catalingheorghe111@gmail.com")
				.htmlTemplate(new Mail.HtmlTemplate("teamAverageReportResults", properties))
				.subject("This is sample email with spring boot and thymeleaf")
				.build();

		senderService.sendEmail(mail);
	}

}
