package com.github.blalasaadri.conference.talks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.UUID;

import static com.github.blalasaadri.conference.talks.Talk.Track.MAIN;
import static com.github.blalasaadri.conference.talks.Talk.Type.LIGHTNING;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class AcceptedTalkTest {

    @Test
    void whenBuilding_titleIsRequired() {
        assertThrows(NullPointerException.class,
                () -> AcceptedTalk.builder(UUID.randomUUID())
                .withTalkAbstract("Something about how everything is short lived.")
                .withSpeaker(mock(Speaker.class))
                .withTalkType(LIGHTNING)
                .withStartTime(ZonedDateTime.now().plusMonths(2).withHour(12).withMinute(0).withSecond(0))
                .withTrack(MAIN)
                .build(),
                "A talk name should be required but isn't");
    }

    @Test
    void whenBuilding_abstractIsRequired() {
        assertThrows(NullPointerException.class,
                () -> AcceptedTalk.builder(UUID.randomUUID())
                        .withTitle("The amazing life of fruit flies and their impact on IT")
                        .withSpeaker(mock(Speaker.class))
                        .withTalkType(LIGHTNING)
                        .withStartTime(ZonedDateTime.now().plusMonths(2).withHour(12).withMinute(0).withSecond(0))
                        .withTrack(MAIN)
                        .build(),
                "An abstract should be required but isn't");
    }

    @Test
    void whenBuilding_speakerIsRequired() {
        assertThrows(NullPointerException.class,
                () -> AcceptedTalk.builder(UUID.randomUUID())
                        .withTitle("The amazing life of fruit flies and their impact on IT")
                        .withTalkAbstract("Something about how everything is short lived.")
                        .withTalkType(LIGHTNING)
                        .withStartTime(ZonedDateTime.now().plusMonths(2).withHour(12).withMinute(0).withSecond(0))
                        .withTrack(MAIN)
                        .build(),
                "A speaker should be required but isn't");
    }

    @Test
    void whenBuilding_typeOfTalkIsRequired() {
        assertThrows(NullPointerException.class,
                () -> AcceptedTalk.builder(UUID.randomUUID())
                        .withTitle("The amazing life of fruit flies and their impact on IT")
                        .withTalkAbstract("Something about how everything is short lived.")
                        .withSpeaker(mock(Speaker.class))
                        .withStartTime(ZonedDateTime.now().plusMonths(2).withHour(12).withMinute(0).withSecond(0))
                        .withTrack(MAIN)
                        .build(),
                "A type of talk should be required but isn't");
    }

    @Test
    void whenBuilding_startTimeIsRequired() {
        assertThrows(NullPointerException.class,
                () -> AcceptedTalk.builder(UUID.randomUUID())
                        .withTitle("The amazing life of fruit flies and their impact on IT")
                        .withTalkAbstract("Something about how everything is short lived.")
                        .withSpeaker(mock(Speaker.class))
                        .withTalkType(LIGHTNING)
                        .withTrack(MAIN)
                        .build(),
                "A starting time should be required but isn't");
    }

    @Test
    void whenBuilding_trackIsRequired() {
        assertThrows(NullPointerException.class,
                () -> AcceptedTalk.builder(UUID.randomUUID())
                        .withTitle("The amazing life of fruit flies and their impact on IT")
                        .withTalkAbstract("Something about how everything is short lived.")
                        .withSpeaker(mock(Speaker.class))
                        .withTalkType(LIGHTNING)
                        .withStartTime(ZonedDateTime.now().plusMonths(2).withHour(12).withMinute(0).withSecond(0))
                        .build(),
                "A track should be required but isn't");
    }

    // TODO More tests
}