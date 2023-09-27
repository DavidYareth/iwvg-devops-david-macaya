package code;

import org.junit.jupiter.api.BeforeEach;
import es.upm.miw.iwvg_devops.code.Search;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

    private Search search;

    @BeforeEach
    void setUp() {
        this.search = new Search();
    }

    @Test
    void testFindUserIdByAllProperFraction(){
        assertEquals(List.of(), search.findUserIdByAllProperFraction()
                .collect(Collectors.toList()));
    }
}
