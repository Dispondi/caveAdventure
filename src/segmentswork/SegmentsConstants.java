package segmentswork;

public final class SegmentsConstants {
    public static final String CORRIDOR_SEGMENT = "corridor";
    public static final String FORK_SEGMENT = "fork";
    public static final String[] ALL_TYPES_SEGMENTS = new String[] {CORRIDOR_SEGMENT, FORK_SEGMENT};
    public static final String CORRIDOR_DESCRIPTION = """
            -----------------
            Вы видите перед собой длинный коридор.
            Желаете пройти дальше?
            Вперед/Назад
            -----------------""";
    public static final String FORK_DESCRIPTION = """
            -----------------
            Блуждая в темном коридоре, вы замечаете свет в конце.
            Вы переступаете через страх и подходите посмотреть.
            """;
    public static final String DOUBLE_FORK_OFFER = """
            Перед вами две двери.
            В какую зайдете?
            Левую/Правую/Назад
            -----------------""";
    public static final String TRIPLE_FORK_OFFER = """
            Перед вами три двери.
            В какую зайдете?
            Левую/Среднюю/Правую/Назад
            -----------------""";
    private SegmentsConstants() {}
}
