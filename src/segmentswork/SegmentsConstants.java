package segmentswork;

public final class SegmentsConstants {
    public static final int MIMIC_PERCENT = 30;
    public static final String CORRIDOR_SEGMENT = "corridor";
    public static final String FORK_SEGMENT = "fork";
    public static final String TREASURE_SEGMENT = "treasure";
    public static final String[] ALL_PLAYABLE_TYPES_SEGMENTS = new String[] {CORRIDOR_SEGMENT, FORK_SEGMENT, TREASURE_SEGMENT};
    public static final String CORRIDOR_DESCRIPTION = """
            -----------------
            Вы видите перед собой длинный коридор. Стены пропитаны влагой, а воздух наполняет запах плесени.
            На полу видны следы, ведущие в темноту. Желаете пройти дальше?
            -Вперед/Назад
            -----------------""";
    public static final String FORK_DESCRIPTION = """
            -----------------
            Блуждая в темном коридоре, вы замечаете свет в конце.
            Вы переступаете через страх и подходите посмотреть.
            """;
    public static final String DOUBLE_FORK_OFFER = """
            Перед вами две двери.
            В какую зайдете?
            -Левую/Правую/Назад
            -----------------""";
    public static final String TRIPLE_FORK_OFFER = """
            Перед вами три двери.
            В какую зайдете?
            -Левую/Среднюю/Правую/Назад
            -----------------""";
    public static final String WIN_DESCRIPTION = """
            -----------------
            Идя по сырым коридорам, вы видите небольшой пучок света, озаряющий стены сырой пещеры.
            Это щель, она ведет наружу. Желаете ли покинуть подземелье?
            -Да/Назад
            -----------------""";
    public static final String DEADEND_DESCRIPTION = """
            -----------------
            Вы пришли в тупик.
            -Назад
            -----------------
            """;
    public static final String TREASURE_CORRIDOR_DESCRIPTION = """
            -----------------
            Вы видите перед собой длинный коридор. Стены пропитаны влагой, а воздух наполняет запах плесени.
            Только небольшая шкатулка с золотом лежит на полу. Желаете пройти дальше?
            -Вперед/Назад/Подобрать
            -----------------
            """;
    public static final String TREASURE_EMPTY_CORRIDOR_DESCRIPTION = """
            -----------------
            Вы видите перед собой длинный коридор. Стены пропитаны влагой, а воздух наполняет запах плесени.
            Только небольшая пустая шкатулка лежит на полу. Желаете пройти дальше?
            -Вперед/Назад
            -----------------
            """;
    private SegmentsConstants() {}
}
