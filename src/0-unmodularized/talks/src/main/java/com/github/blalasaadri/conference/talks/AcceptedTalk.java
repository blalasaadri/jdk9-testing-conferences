package com.github.blalasaadri.conference.talks;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

/**
 * TODO
 */
public final class AcceptedTalk implements Talk {

    private final UUID id;
    private final String title, talkAbstract;
    private final Speaker speaker;
    private final Type type;
    private final ZonedDateTime startTime;
    private final Track track;

    private AcceptedTalk(UUID id, String title, String talkAbstract, Speaker speaker, Type type, ZonedDateTime startTime, Track track) {
        requireNonNull(id, "There has to be an ID");
        requireNonNull(title, "The talk must be named");
        requireNonNull(talkAbstract, "The talk must have an abstract");
        requireNonNull(speaker, "The talk must have a speaker");
        requireNonNull(type, "The talk must be of some type");
        requireNonNull(startTime, "The talk must start at some point");
        requireNonNull(track, "The talk must be in a known track");

        this.id = id;
        this.title = title;
        this.talkAbstract = talkAbstract;
        this.speaker = speaker;
        this.type = type;
        this.startTime = startTime;
        this.track = track;
    }

    @Nonnull
    @Override
    public UUID getId() {
        return id;
    }

    @Nonnull
    @Override
    public String getTitle() {
        return title;
    }

    @Nonnull
    @Override
    public String getTalkAbstract() {
        return talkAbstract;
    }

    @Nonnull
    public AcceptedTalk withTalkAbstract(@Nonnull String talkAbstract) {
        return new AcceptedTalk(id, title, talkAbstract, speaker, type, startTime, track);
    }

    @Nonnull
    @Override
    public Speaker getSpeaker() {
        return speaker;
    }

    @Nonnull
    @Override
    public Duration getDuration() {
        return type.getDuration();
    }

    @Nonnull
    @Override
    public Type getType() {
        return type;
    }

    @Nonnull
    public Optional<ZonedDateTime> getStartTime() {
        return Optional.of(startTime);
    }

    @Nonnull
    public AcceptedTalk withStartTime(@Nonnull ZonedDateTime startTime) {
        return new AcceptedTalk(id, title, talkAbstract, speaker, type, startTime, track);
    }

    @Nonnull
    public Optional<Track> getTrack() {
        return Optional.of(track);
    }

    @Nonnull
    public AcceptedTalk withTrack(@Nonnull Track track) {
        return new AcceptedTalk(id, title, talkAbstract, speaker, type, startTime, track);
    }

    public static AcceptedTalkBuilder builder(Talk talk) {
        return new AcceptedTalkBuilder(talk);
    }

    public static AcceptedTalkBuilder builder(UUID id) {
        return new AcceptedTalkBuilder(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talk that = (Talk) o;

        if (!id.equals(that.getId())) return false;
        return speaker.equals(that.getSpeaker());
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + speaker.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AcceptedTalk{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", talkAbstract='" + talkAbstract + '\'' +
                ", speaker=" + speaker +
                ", type=" + type +
                ", startTime=" + startTime +
                ", track=" + track +
                '}';
    }

    /**
     * TODO
     */
    public static class AcceptedTalkBuilder {
        private UUID id;
        private String title, talkAbstract;
        private Speaker speaker;
        private Type type;
        private ZonedDateTime startTime;
        private Track track;

        public AcceptedTalkBuilder(Talk talk) {
            fromTalk(talk);
        }

        public AcceptedTalkBuilder(UUID id) {
            this.id = id;
        }

        @Nonnull
        public AcceptedTalkBuilder fromTalk(@Nonnull Talk talk) {
            this.id = talk.getId();
            this.title = talk.getTitle();
            this.talkAbstract = talk.getTalkAbstract();
            this.speaker = talk.getSpeaker();
            this.type = talk.getType();
            return this;
        }

        @Nonnull
        public AcceptedTalkBuilder withTitle(@Nonnull String title) {
            this.title = title;
            return this;
        }

        @Nonnull
        public AcceptedTalkBuilder withTalkAbstract(@Nonnull String talkAbstract) {
            this.talkAbstract = talkAbstract;
            return this;
        }

        @Nonnull
        AcceptedTalkBuilder withSpeaker(@Nonnull Speaker speaker) {
            this.speaker = speaker;
            return this;
        }

        @Nonnull
        public AcceptedTalkBuilder withTalkType(@Nonnull Type type) {
            this.type = type;
            return this;
        }

        @Nonnull
        public AcceptedTalkBuilder withStartTime(@Nonnull ZonedDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        @Nonnull
        public AcceptedTalkBuilder withTrack(@Nonnull Track track) {
            this.track = track;
            return this;
        }

        @Nonnull
        public AcceptedTalk build() {
            return new AcceptedTalk(id, title, talkAbstract, speaker, type, startTime, track);
        }
    }
}
