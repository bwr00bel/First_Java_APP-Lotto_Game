package inputDataTest;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class UserInputDataTest {

    @Test
    void should_return_six_numbers_from_1_to_100() {
//given
        Set<Integer> expectedSetNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        UserInputData userInputData = new UserInputDataTest();
        String givenNumbers = "1,2,3,4,5,6";
        Scanner scn = mockGivenNumber(givenNumbers);
        //then
        Set<Integer> inputNumbersSet = userInputData.loadNumberFromUSer(scn);
//when
        assertThat(inputNumbersSet, equalTo(expectedSetNumbers));

    }

    @Test
    void should_return_numbers_when_1_isnot_set() {
        //given
        Set<Integer> expectedSetNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        UserInputData userInputData = new UserInputData();
        String givenNums = "1,2,4,5,6,-1";
        Scanner scn = mockGivenNumber(givenNums);
        //then
        Set<Integer> inputNumberSet = userInputData.loadNumberFromUser(scn);
        //when
        assertThat(inputNumberSet, equalTo(expectedSetNumbers));
    }

    @Test
    void should_return_empty_set_nums_out_of_range(){
       //givem
        Set<Integer> expectedSetNumbers = Collections.emptySet();
        UserInputData userInputData = new UserInputData();
        String givenNums = "-1,-2,-3,-4-,-5,101";
        Scanner scn = mockGivenNumber(givenNums);
        //then
        Set<Integer> inputSetNumbers = userInputData.loadNumberFromUser(scn);
        //when
        assertThat(inputSetNumbers, equalTo(expectedSetNumbers));
    }




    private Scanner mockGivenNumber(String givenNumbers) {

        InputStream inputStream = System.in;

        System.setIn(new ByteArrayInputStream(givenNumbers.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(inputStream);
        return scanner;
    }
}


