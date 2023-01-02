package org.csu.webJpetStore.persistence;

import org.csu.webJpetStore.domain.Sequence;

public interface SequenceDAO {
    Sequence getSequence(Sequence sequence);

    void updateSequence(Sequence sequence);
}
