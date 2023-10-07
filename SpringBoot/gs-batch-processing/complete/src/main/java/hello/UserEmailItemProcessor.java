package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class UserEmailItemProcessor implements ItemProcessor<UserEmail, UserEmail> {

    private static final Logger log = LoggerFactory.getLogger(UserEmailItemProcessor.class);

    @Override
    public UserEmail process(final UserEmail person) throws Exception {
        final String firstName = person.getEmailAddress().toUpperCase();
        /*final String lastName = person.getEmailFormat() != null ?
                person.getEmailFormat().toUpperCase() : "" ;

        final UserEmail transformedPerson = new UserEmail(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");
*/

        final UserEmail transformedPerson = new UserEmail(firstName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");
        return transformedPerson;
    }

}
