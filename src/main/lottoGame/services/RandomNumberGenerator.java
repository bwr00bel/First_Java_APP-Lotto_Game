package services;

import config.DataConfig;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {
    Set<Integer> generateRandomNumbers() {
        Set<Integer> setOfGeneratedRandomNumber = new HashSet<>();
        SecureRandom random = new SecureRandom();
        while (setOfGeneratedRandomNumber.size() < DataConfig.REQUIRED_NUMBERS){
            int generatedNumber = random.nextInt(DataConfig.MAX_RANGE)+DataConfig.MIN_RANGE;
            setOfGeneratedRandomNumber.add(generatedNumber);
        }
        return setOfGeneratedRandomNumber;
    }

}

