package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Search {

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll().filter(user -> user.getFractions().stream()
                .allMatch(Fraction::isProper)).map(User::getId);
    }

}