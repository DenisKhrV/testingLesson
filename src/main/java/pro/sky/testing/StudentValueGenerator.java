package pro.sky.testing;

public class StudentValueGenerator {
    private static int DEFAULT_MAX = 100;
    private static int DEFAULT_MIN = 1;

    public int generateAgeIsRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int generateAge() {
        return generateAgeIsRange(DEFAULT_MIN, DEFAULT_MAX);
    }
}