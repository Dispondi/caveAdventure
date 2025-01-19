package support;

public final class SupportOperations {
    public static int randInRange(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static String takeRandObjectFromArray(String[] array) {
        return array[randInRange(0, array.length - 1)];
    }

    private SupportOperations() {}
}
