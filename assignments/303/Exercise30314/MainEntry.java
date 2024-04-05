package Exercise30314;

import java.util.Arrays;
import java.util.List;

public class MainEntry {

    Calc<Integer, Integer> adder = new Calc<Integer, Integer>() {
        @Override
        public Integer compute(Integer[] arr) {
            var numbers = List.of(arr);
            return numbers.stream().reduce(Integer::sum).orElse(0);
        }
    };

    Calc<Integer, Integer> difference = new Calc<Integer, Integer>() {
        @Override
        public Integer compute(Integer[] arr) {
            var numbers = List.of(arr);
            return numbers.stream().reduce((prev, next)-> prev - next).orElse(0);
        }
    };
    Calc<Integer, Integer> multiply = new Calc<Integer, Integer>() {
        @Override
        public Integer compute(Integer[] arr) {
            var numbers = List.of(arr);
            return numbers.stream().reduce((prev, next)-> prev * next).orElse(0);
        }
    };

    Calc<Integer, Integer> division = new Calc<Integer, Integer>() {
        @Override
        public Integer compute(Integer[] arr) {
            return (arr[0] / arr[1]);
        }
    };

//
}
