package org.soluvas.data.shell; 

import java.util.List;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to show an entity of {@link Person}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="cat", description="Get Person by ID.")
public class PersonCatCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonCatCommand.class);

	@Option(name="--index", description="Find Person by index (not by ID). Index starts at 1 (as displayed by 'ls').")
	private Boolean byIndex;
	
	@Argument(index=0, name="id", required=true, description="Person ID.")
	private String id;
	
	private final PersonRepository personRepo;
	
	@Inject
	public PersonCatCommand(PersonRepository personRepo) {
		super();
		this.personRepo = personRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		if (byIndex == null || byIndex == true) {
			Integer parsedId = null;
			try {
				parsedId = Integer.valueOf(id);
				// TODO: natively support findOneByIndex in Repository
				final List<Person> personList = personRepo.findAll();
				return personList.get(parsedId - 1);
			} catch (NumberFormatException e) {
				if (byIndex != null && byIndex == true) {
					throw e;
				} else {
					return personRepo.findOne(id);
				}
			}
		} else {
			return personRepo.findOne(id);
		}
	}

}