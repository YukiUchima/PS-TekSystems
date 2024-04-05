package Exercise30314;

@FunctionalInterface
public interface Calc<T, R> {
    T compute(R[] arr);
}
