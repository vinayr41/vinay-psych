package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "stats")
public class Stats extends Auditable {
    @Getter
    @Setter
    private long getPsychedCount = 0;
    @Getter
    @Setter
    private long psychedOthersCount = 0;
    @Getter
    @Setter
    private long correctAnswerCount = 0;
}
