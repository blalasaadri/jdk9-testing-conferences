package com.github.blalasaadri.conference.speakers;

import com.github.blalasaadri.conference.talks.proposal.CallForPapers;
import com.github.blalasaadri.conference.speakers.internal.SpeakerImpl;
import com.github.blalasaadri.conference.talks.Talk;
import com.github.blalasaadri.conference.talks.Talk.Type;
import com.github.blalasaadri.conference.talks.proposal.ProposedTalk;

import java.time.*;
import java.util.Comparator;
import java.util.List;

public class Start {

    public static void main(String... args) {
        CallForPapers cfp = new CallForPapers(
                "JCON 2017",
                ZonedDateTime.of(
                        LocalDate.of(2017, Month.OCTOBER, 24),
                        LocalTime.of(9, 00),
                        ZoneId.of("Europe/Berlin")
                ),
                ZonedDateTime.of(
                        LocalDate.of(2017, Month.OCTOBER, 26),
                        LocalTime.of(17, 00),
                        ZoneId.of("Europe/Berlin")
                )
        );

        cfp = proposeTalks(cfp);

        cfp.proposedTalks()
                .stream()
                .map(Talk::getTitle)
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

    }

    private static CallForPapers proposeTalks(CallForPapers cfp) {
        SpeakerImpl alasdairCollinson = SpeakerImpl.builder()
                .withName("Alasdair Collinson")
                .withCompanyOrInstitute("Senacor Technologies AG")
                .withJobTitle("Senior Developer")
                .withQualifications(List.of(
                        "Speaker at Droidcon Berlin 2013",
                        "Keynote speaker at Voxxed Days Vienna 2017"
                ))
                .build();
        SpeakerImpl normanNull = SpeakerImpl.builder()
                .withName("Norman Null")
                .withJobTitle("Principal Architect")
                .withCompanyOrInstitute("Demoworks GmbH")
                .build();
        SpeakerImpl melonUsk = SpeakerImpl.builder()
                .withName("Melon Usk")
                .withJobTitle("Chief Interplanetary Engineer")
                .withQualifications(List.of(
                        "Founder of SpaceY",
                        "Future Martian",
                        "Speaker at Galaxycon 2015"
                )).withCompanyOrInstitute("SpaceY")
                .build();

        return cfp.proposeTalk(
                ProposedTalk.builder()
                        .withTitle("Awesome unit tests for awesome people")
                        .withTalkType(Type.FULL)
                        .withSpeaker(alasdairCollinson)
                        .withTalkAbstract(
                                "Most experienced programmers agree that unit tests are vital for a successful " +
                                        "project. Nevertheless, in most projects you will find tests of varying " +
                                        "readability, meaningfulness and helpfulness - tests of inconsistent " +
                                        "quality, for short. I'm going to hightlight what I thinks makes unit tests " +
                                        "readable and helpful to the reader while still remaining meaningful as " +
                                        "actual tests. Also, I'll talk about how YOU can make your tests awesome " +
                                        "while not focusing too much on specific technologies."
                        ).build()
        ).proposeTalk(
                ProposedTalk.builder()
                        .withTitle("Don't trust the module - Unit testing with Project Jigsaw")
                        .withTalkType(Type.FULL)
                        .withSpeaker(alasdairCollinson)
                        .withTalkAbstract(
                                "Project Jigsaw is here. It's real. It wants to be used. It NEEDS to be tested. " +
                                        "But testing isn't trivial, especially when things change so dramatically. " +
                                        "The module system introduced in JDK 9 brings new complexities in many ways " +
                                        "and testing is one of them. How can I make sure, that my testing framework " +
                                        "can even *see* my classes without completely missing the point of " +
                                        "modularization? How can I make sure, that my modules do what they're " +
                                        "supposed to do? And why can't we just test like we always have? All this " +
                                        "will be covered - and more."
                        ).build()
        ).proposeTalk(
                ProposedTalk.builder()
                        .withTitle("The curse of being Null")
                        .withTalkType(Type.LIGHTNING)
                        .withSpeaker(normanNull)
                        .withTalkAbstract(
                                "With a name such as 'Norman Null', you run into problems in many places. Many " +
                                        "Websites won't let me register, I have been denied credit cards because " +
                                        "the software couldn't handle my name and I've had flights canceled because " +
                                        "some system suspected a bug when it saw my name. Therefore I have made it my" +
                                        "mission in life to build and maintain clean software that can cope with " +
                                        "corner cases rather than only serving those 95% of users who don't have " +
                                        "unusual names, unexpected home addresses or were born on February 29th."
                        ).build()
        ).proposeTalk(
                ProposedTalk.builder()
                        .withTitle("Getting to Mars with a banana - DIY fruit based space travel")
                        .withTalkType(Type.WORKSHOP)
                        .withSpeaker(melonUsk)
                        .withTalkAbstract(
                                "Since the dawn of time, mankind has been dreaming of traveling to the stars. Now, " +
                                        "with a few decades of experience with maned space travel, this dream is " +
                                        "closer than it ever has been in all of known history. And it turns out, " +
                                        "it's not even that difficult. In this workshop I will show you how to build " +
                                        "a fully functional space ship using a banana and some other common household " +
                                        "items."
                        ).build()
        );
    }
}
