package com.github.blalasaadri.conference.talks;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

public interface Talk {

    @Nonnull
    UUID getId();

    @Nonnull
    String getTitle();

    @Nonnull
    String getTalkAbstract();

    @Nonnull
    Speaker getSpeaker();

    @Nonnull
    Duration getDuration();

    @Nonnull
    Type getType();

    @Nonnull
    default Optional<ZonedDateTime> getStartTime() {
        return Optional.empty();
    }

    @Nonnull
    default Optional<AcceptedTalk.Track> getTrack() {
        return Optional.empty();
    }

    enum Type {
        LIGHTNING(Duration.ofMinutes(5)),
        FULL(Duration.ofMinutes(50)),
        WORKSHOP(Duration.ofHours(3));

        private Duration duration;

        Type(Duration duration) {
            this.duration = duration;
        }

        @Nonnull
        public Duration getDuration() {
            return duration;
        }
    }

    /**
     * TODO
     */
    enum Track {
        JAVA_FX, MAIN, TESTING_AND_QUALITY
    }
}
