package basic.copy;

import java.time.LocalDateTime;

public final class Period {

    private final LocalDateTime start;
    private final LocalDateTime end;

    public Period(LocalDateTime start, LocalDateTime end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    public LocalDateTime start() {
        return start;
    }

    public LocalDateTime end() {
        return end;
    }
}
