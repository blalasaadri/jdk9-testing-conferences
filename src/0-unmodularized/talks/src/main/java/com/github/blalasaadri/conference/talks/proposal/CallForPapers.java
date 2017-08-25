package com.github.blalasaadri.conference.talks.proposal;

import com.github.blalasaadri.conference.talks.Speaker;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CallForPapers {

    private String conferenceName;
    private ZonedDateTime beginning, end;
    private Set<ProposedTalk> proposedTalks;

    public CallForPapers(@Nonnull String conferenceName, @Nonnull ZonedDateTime beginning, @Nonnull ZonedDateTime end) {
        this(conferenceName, beginning, end, new HashSet<>());
    }

    private CallForPapers(String conferenceName, ZonedDateTime beginning, ZonedDateTime end, Set<ProposedTalk> proposedTalks) {
        this.conferenceName = conferenceName;
        this.beginning = beginning;
        this.end = end;
        this.proposedTalks = proposedTalks;
    }

    @Nonnull
    public CallForPapers proposeTalk(@Nonnull ProposedTalk proposedTalk) {
        Set<ProposedTalk> proposedTalks = new HashSet<>(this.proposedTalks);
        proposedTalks.add(proposedTalk);
        return new CallForPapers(conferenceName, beginning, end, proposedTalks);
    }

    @Nonnull
    public List<ProposedTalk> proposedTalks() {
        return proposedTalksMatching(talk -> true);
    }

    @Nonnull
    public List<ProposedTalk> proposedTalksBy(@Nullable Speaker speaker) {
        return proposedTalksMatching(talk -> Objects.equals(speaker, talk.getSpeaker()));
    }

    @Nonnull
    public List<ProposedTalk> proposedTalksMatching(@Nonnull Predicate<ProposedTalk> predicate) {
        return proposedTalks.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallForPapers that = (CallForPapers) o;

        if (!conferenceName.equals(that.conferenceName)) return false;
        if (!beginning.equals(that.beginning)) return false;
        if (!end.equals(that.end)) return false;
        return proposedTalks.equals(that.proposedTalks);
    }

    @Override
    public int hashCode() {
        int result = conferenceName.hashCode();
        result = 31 * result + beginning.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + proposedTalks.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CallForPapers{" +
                "conferenceName='" + conferenceName + '\'' +
                ", beginning=" + beginning +
                ", end=" + end +
                ", proposedTalks=" + proposedTalks +
                '}';
    }
}
