package support;

public final class SupportOperations {
    public static int randInRange(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private SupportOperations() {}
}
