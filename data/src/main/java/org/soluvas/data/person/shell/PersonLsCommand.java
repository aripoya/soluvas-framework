package org.soluvas.data.person.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Person;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to list entities of {@link Person}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="ls", description="List Person entities.")
public class PersonLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonLsCommand.class);

	@Option(name="--page", description="Page number.")
	private transient long pageNumber = 0;
	@Option(name="--pagesize", description="Page size.")
	private transient long pageSize = 100;
	@Option(name="--sort", description="Sort property.")
	private transient String sortProperty = "modificationTime";
	@Option(name="--sortdir", description="Sort direction.")
	private transient Direction sortDir = Direction.DESC;
	
	private final PersonRepository personRepo;
	
	@Inject
	public PersonLsCommand(PersonRepository personRepo) {
		super();
		this.personRepo = personRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-15s|%-21s|%-20s|@",
				"№", "ID", "Slug", "Name", "Email(s)" ));
		final Page<Person> personPage = personRepo.findAll(new PageRequest(pageNumber, pageSize, sortDir, sortProperty));
		int i = 0;
		for (Person it : personPage.getContent()) {
			final String genderStr = it.getGender() == Gender.MALE ? "@|bold,blue ♂|@" : it.getGender() == Gender.FEMALE ? "@|bold,magenta ♀|@" : " ";
			String emails = "";
			if (!it.getEmails().isEmpty()) {
				for (final Email email : it.getEmails()) {
					if (emails.equals("")) {
						emails += email.getEmail();
					} else {
						emails += " " + email.getEmail();
					}
				}
			} else {
				emails = it.getEmail();
			}
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-15s|@@|bold,black ||@%-15s@|bold,black ||@" + genderStr + "%-20s@|bold,black ||@%-20s",
				++i, it.getId(), it.getSlug(), it.getName(), emails) );
		}
		System.out.println(ansi().render("@|bold %d|@ of @|bold %d|@ Person entities",
			personPage.getNumberOfElements(), personPage.getTotalElements()));
		return personPage.getTotalElements();
	}

}