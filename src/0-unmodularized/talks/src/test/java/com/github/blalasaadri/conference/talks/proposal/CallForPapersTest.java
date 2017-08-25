package com.github.blalasaadri.conference.talks.proposal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CallForPapersTest {

    @Test
    public void cpfIsImmutable() {
        // Given
        CallForPapers cfp = new CallForPapers(
                "TestUnit",
                ZonedDateTime.now().plusDays(1).withHour(9).withMinute(0).withSecond(0),
                ZonedDateTime.now().plusDays(3).withHour(17).withMinute(0).withSecond(0)
        );
        // When
        CallForPapers changedCfp = cfp.proposeTalk(Mockito.mock(ProposedTalk.class));
        // Then
        assertAll(
                () -> assertNotEquals(changedCfp, cfp),
                () -> assertEquals(changedCfp.proposedTalks().size(), cfp.proposedTalks().size()),
                () -> assertNotEquals(changedCfp.proposedTalks(), cfp.proposedTalks())
        );
    }
}