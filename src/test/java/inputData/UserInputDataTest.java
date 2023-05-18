package inputData;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class UserInputDataTest {

    @Test
    void should_return_six_numbers_from_1_to_100() {
//given
        Set<Integer> expectedSetNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        UserInputData userInputData = new UserInputData();
        String givenNumbers = "1,2,3,4,5,6";
        Scanner scn = mockGivenNumber(givenNumbers);
        //then
        Set<Integer> inputNumbersSet = userInputData.loadNumberFromUSer(scn);
//when
        assertThat(inputNumbersSet, equalTo(expectedSetNumbers));

    }

    private Scanner mockGivenNumber(String givenNumbers) {

        InputStream inputStream = System.in;

        System.setIn(new ByteArrayInputStream(givenNumbers.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(inputStream);
        return scanner;
    }
}


