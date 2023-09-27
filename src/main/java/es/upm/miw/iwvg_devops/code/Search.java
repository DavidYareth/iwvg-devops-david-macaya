package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Search {

    private final UsersDatabase usersDatabase;

    public Search() {
        this.usersDatabase = new UsersDatabase();
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return usersDatabase.findAll().filter(user -> user.getFractions().stream()
                .allMatch(Fraction::isProper)).map(User::getId);
    }

}