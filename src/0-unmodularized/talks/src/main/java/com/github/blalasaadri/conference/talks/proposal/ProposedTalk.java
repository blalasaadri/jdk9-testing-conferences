package com.github.blalasaadri.conference.talks.proposal;

import com.github.blalasaadri.conference.talks.Speaker;
import com.github.blalasaadri.conference.talks.Talk;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

/**
 * TODO
 */
public final class ProposedTalk implements Talk {

    private final UUID id;
    private final String title, talkAbstract;
    private final String notes;
    private final Speaker speaker;
    private final Type type;

    private ProposedTalk(String title, String talkAbstract, String notes, Speaker speaker, Type type) {
        requireNonNull(title, "Try coming up with a catchy title, won't you?");
        requireNonNull(talkAbstract, "Don't you know, what you'll be talking about? Every talk must have an abstract");
        requireNonNull(speaker, "This talk won't hold itself.");
        requireNonNull(type, "You have to choose a type of talk. No way around it.");

        this.id = UUID.fromString(title);
        this.title = title;
        this.talkAbstract = talkAbstract;
        this.notes = notes;
        this.speaker = speaker;
        this.type = type;
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
    public ProposedTalk withTitle(@Nonnull String title) {
        return new ProposedTalk(title, talkAbstract, notes, speaker, type);
    }

    @Nonnull
    @Override
    public String getTalkAbstract() {
        return talkAbstract;
    }

    @Nonnull
    public ProposedTalk withTalkAbstract(@Nonnull String talkAbstract) {
        return new ProposedTalk(title, talkAbstract, notes, speaker, type);
    }

    @Nonnull
    public Optional<String> getNotes() {
        return Optional.ofNullable(notes);
    }

    @Nonnull
    public ProposedTalk withNotes(@Nullable String notes) {
        return new ProposedTalk(title, talkAbstract, notes, speaker, type);
    }

    @Nonnull
    @Override
    public Speaker getSpeaker() {
        return speaker;
    }

    // The speaker cannot be changed

    @Nonnull
    @Override
    public Duration getDuration() {
        return type.getDuration();
    }

    // The duration is derived from the talk type and so cannot be changed

    @Nonnull
    @Override
    public Type getType() {
        return type;
    }

    @Nonnull
    public ProposedTalk withTalkType(@Nonnull Type type) {
        return new ProposedTalk(title, talkAbstract, notes, speaker, type);
    }

    @Nonnull
    public static ProposedTalkBuilder builder() {
        return new ProposedTalkBuilder();
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
        return "ProposedTalk{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", talkAbstract='" + talkAbstract + '\'' +
                ", notes='" + notes + '\'' +
                ", speaker=" + speaker +
                ", type=" + type +
                '}';
    }

    /**
     * TODO
     */
    public static class ProposedTalkBuilder {

        private String title, talkAbstract, notes;
        private Speaker speaker;
        private Type type;

        @Nonnull
        public ProposedTalkBuilder withTitle(@Nonnull String title) {
            this.title = title;
            return this;
        }

        @Nonnull
        public ProposedTalkBuilder withTalkAbstract(@Nonnull String talkAbstract) {
            this.talkAbstract = talkAbstract;
            return this;
        }

        @Nonnull
        public ProposedTalkBuilder withNotes(@Nullable String notes) {
            this.notes = notes;
            return this;
        }

        @Nonnull
        public ProposedTalkBuilder withSpeaker(@Nonnull Speaker speaker) {
            this.speaker = speaker;
            return this;
        }

        @Nonnull
        public ProposedTalkBuilder withTalkType(@Nonnull Type type) {
            this.type = type;
            return this;
        }

        @Nonnull
        public ProposedTalk build() {
            return new ProposedTalk(title, talkAbstract, notes, speaker, type);
        }
    }
}
