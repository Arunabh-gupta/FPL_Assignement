package io.aiven.spring.mysql.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NumberController {

    @Autowired
    private NumberRepository numberRepository;

    // Convert seconds to a readable format
    private String convertSeconds(int seconds) {
        int totalMinutes = seconds / 60;
        int totalHours = totalMinutes / 60;

        if (totalMinutes < 1) {
            return seconds + "s";
        } else if (totalHours < 1) {
            return totalMinutes + "m";
        }
        return totalHours + "h";
    }

    // Add a number
    @PostMapping("/addNumber")
    public void addNumber(@RequestParam int number) {
        String result = convertSeconds(number);
        char groupKey = result.charAt(result.length() - 1);

        NumberEntity entity = new NumberEntity();
        entity.setNumber(number);
        entity.setGroupKey(groupKey);

        numberRepository.save(entity);
    }

    // Get all groups
    @GetMapping("/getNumber")
    public Map<Character, List<Integer>> getGroups() {
        return numberRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        NumberEntity::getGroupKey,
                        Collectors.mapping(NumberEntity::getNumber, Collectors.toList())
                ));
    }
}

