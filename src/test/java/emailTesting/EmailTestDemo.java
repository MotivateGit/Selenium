package emailTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Attachment;
import com.mailosaur.models.Code;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class EmailTestDemo {

	@Test
	public void testEmail() throws IOException, MailosaurException {
		String apiKey = "JV0gzDIkCpqXDwMVLgcuhwkmSJMaR6FM";
		String serverId = "c7i2mt7x";
		String serverDomain = "c7i2mt7x.mailosaur.net";

		MailosaurClient mailosaur = new MailosaurClient(apiKey);

		MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);

		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo("anything@" + serverDomain);

		Message message = mailosaur.messages().get(params, criteria);
		System.out.println(message.subject());
		System.out.println(message.from().get(0).email());
		System.out.println(message.to().get(0).email());
		System.out.println(message.cc());

		// Check email message body information
		System.out.println("--body--");
		System.out.println(message.text().body());
		assertTrue(message.text().body().contains("Are you happy"), "Email message body not matching");

		assertNotNull(message);
		assertEquals("Rate 'SAMSUNG Galaxy F34 5G (Mystic...' based on your experience", message.subject());

		// Fetch and validate the links in body

		// How many links?
		System.out.println("--Links--");
		System.out.println(message.html().links().size());

		List<Link> allLinks = message.html().links();
		for (Link link : allLinks) {
			System.out.println(link.text()); // "Google Search"
			System.out.println(link.href()); // "https://www.google.com/"
		}

		// Validate email attachments
		System.out.println("----Email Attachements----");
		System.out.println(message.attachments().size()); // 2

		Attachment firstAttachment = message.attachments().get(0);
		System.out.println(firstAttachment.fileName()); // "contract.pdf"
		System.out.println(firstAttachment.contentType()); // "application/pdf"
		System.out.println(firstAttachment.length());

		// Saving attachment to the Disk

		byte[] file = mailosaur.files().getAttachment(firstAttachment.id());
		Path path = Paths.get(firstAttachment.fileName());

		Files.write(file, path.toFile());

		// Fetching the OTP NUmber

		// How many codes?
		System.out.println("---Fetching the OTP NUmber---");
		System.out.println(message.text().codes().size()); // 2

		Code firstCode = message.text().codes().get(0);
		System.out.println(firstCode.value()); // "456812"

		// Fetching the OTP NUmber using Regular Expression
		System.out.println("---Fetching the OTP NUmber using Regular Expression---");
		System.out.println(message.text().body()); // "Your access code is 243546."

		Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
		Matcher matcher = pattern.matcher(message.text().body());
		matcher.find();

		System.out.println(matcher.group(1)); // "243546"

	}

}
