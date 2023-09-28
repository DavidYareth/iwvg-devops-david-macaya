package es.upm.miw.iwvg_devops.code;

import java.util.Comparator;
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

    public Fraction findHighestFraction() {
        return this.usersDatabase.findAll()
                .flatMap(user -> user.getFractions().stream())
                .max(Comparator.comparing(Fraction::decimal))
                .orElse(null);
    }

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return this.usersDatabase.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(user -> user.getFamilyName().substring(0, 1) + ".");
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return this.usersDatabase.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::divide).orElse(null);
    }
}