package vn.techzen.academy_12.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_12.entity.Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("dictionary")
public class DictionaryController {
    private List<Dictionary> dictionaries = new ArrayList<Dictionary>(
            Arrays.asList(
                    new Dictionary(1,"hello", "Xin chào"),
                    new Dictionary(2,"thank","Cảm ơn"),
                    new Dictionary(3,"eat","Ăn"),
                    new Dictionary(4,"drink","đồ uống")

            )
    );
    @GetMapping("/{name}")
    public ResponseEntity<Dictionary> getDictionary(@PathVariable String name) {
        for (Dictionary dictionary : dictionaries) {
            if (Objects.equals(dictionary.getWord(), name)) {
                return ResponseEntity.ok(dictionary);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
