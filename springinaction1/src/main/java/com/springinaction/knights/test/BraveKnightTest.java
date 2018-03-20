package com.springinaction.knights.test;

import static org.mockito.Mockito.*;

import com.springinaction.knights.BraveKnight;
import com.springinaction.knights.Quest;
import org.junit.Test;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
