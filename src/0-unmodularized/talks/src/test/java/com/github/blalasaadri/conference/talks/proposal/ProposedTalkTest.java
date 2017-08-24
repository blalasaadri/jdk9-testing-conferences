package com.github.blalasaadri.conference.talks.proposal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.blalasaadri.conference.talks.Speaker;
import com.github.blalasaadri.conference.talks.Talk;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProposedTalkTest {

    @Test
    void whenBuilding_titleIsRequired() {
        assertThrows(NullPointerException.class, () ->
                ProposedTalk.builder()
                        .withTalkAbstract("My talk will be fabulous. It will be the best talk ever.")
                        .withNotes("Trust me.")
                        .withSpeaker(Mockito.mock(Speaker.class))
                        .withTalkType(Talk.Type.FULL)
                        .build(),
                "Try coming up with a catchy title, won't you?"
        );
    }

    @Test
    void whenBuilding_abstractIsRequired() {
        assertThrows(NullPointerException.class, () ->
                ProposedTalk.builder()
                        .withTitle("The bestest talk ever")
                        .withNotes("Trust me.")
                        .withSpeaker(Mockito.mock(Speaker.class))
                        .withTalkType(Talk.Type.FULL)
                        .build(),
                "Don't you know, what you'll be talking about? Every talk must have an abstract"
        );
    }

    @Test
    void whenBuilding_notesAreNotRequired() {
        ProposedTalk talk = ProposedTalk.builder()
                .withTitle("The bestest talk ever")
                .withTalkAbstract("My talk will be fabulous. It will be the best talk ever.")
                .withSpeaker(Mockito.mock(Speaker.class))
                .withTalkType(Talk.Type.FULL)
                .build();

        assertNotNull(talk);
    }

    @Test
    void whenBuilding_speakerIsRequired() {
        assertThrows(NullPointerException.class, () ->
                ProposedTalk.builder()
                        .withTitle("The bestest talk ever")
                        .withTalkAbstract("My talk will be fabulous. It will be the best talk ever.")
                        .withNotes("Trust me.")
                        .withTalkType(Talk.Type.FULL)
                        .build(),
                "This talk won't hold itself."
        );
    }

    @Test
    void whenBuilding_talkTypeIsRequired() {
        assertThrows(NullPointerException.class, () ->
                ProposedTalk.builder()
                        .withTitle("The bestest talk ever")
                        .withTalkAbstract("My talk will be fabulous. It will be the best talk ever.")
                        .withNotes("Trust me.")
                        .withSpeaker(Mockito.mock(Speaker.class))
                        .build(),
                "You have to choose a type of talk. No way around it."
        );
    }

    // TODO more tests
}