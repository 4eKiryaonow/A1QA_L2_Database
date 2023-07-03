package utils.sql;

import model.sql.Test;
import service.sql.ServiceTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static constants.sql.RegExpQueryConstants.DOUBLE_DIGIT_REGEX;

public class RandomUtils {
    public static List<Long> getRandomDoubleDigitTestIdList(int amount) {
        ServiceTest serviceTest = new ServiceTest();
        List<Test> testList = serviceTest.getTestListByRegExp(DOUBLE_DIGIT_REGEX);
        Random random = new Random();
        HashSet<Long> doubleDigitIdList = new HashSet<>();
        while (doubleDigitIdList.size() < amount) {
            int indexList = random.nextInt(testList.size());
            Test test = testList.get(indexList);
            long testId = test.getId();
            doubleDigitIdList.add(testId);
        }
        List<Long> numbersList = new ArrayList<>(doubleDigitIdList);
        return numbersList;
    }
}