package com.github.blalasaadri.conference.talks.proposal;

import com.github.blalasaadri.conference.talks.Speaker;
import com.github.blalasaadri.conference.talks.Talk;

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

    public CallForPapers(String conferenceName, ZonedDateTime beginning, ZonedDateTime end) {
        this.conferenceName = conferenceName;
        this.beginning = beginning;
        this.end = end;
        this.proposedTalks = new HashSet<>();
    }

    public Talk proposeTalk(ProposedTalk proposedTalk) {
        proposedTalks.add(proposedTalk);
        return proposedTalk;
    }

    public List<ProposedTalk> proposedTalks() {
        return proposedTalksMatching(talk -> true);
    }

    public List<ProposedTalk> proposedTalksBy(Speaker speaker) {
        return proposedTalksMatching(talk -> Objects.equals(speaker, talk.getSpeaker()));
    }

    public List<ProposedTalk> proposedTalksMatching(Predicate<ProposedTalk> predicate) {
        return proposedTalks.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
