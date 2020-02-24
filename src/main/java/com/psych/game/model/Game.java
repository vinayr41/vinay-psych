package com.psych.game.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "games")
public class Game extends Auditable {
    @ManyToMany
    @JsonIdentityReference
    @Getter
    @Setter
    private Set<Player> players = new HashSet<>();

    @Setter @Getter
    @Enumerated(EnumType.STRING)
    @NotNull
    private GameMode gameMode;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    @Getter
    @Setter
    @JsonManagedReference
    private List<Round> rounds = new ArrayList<>();

    @Getter
    @Setter
    private Boolean hasEllen = false;

    @Getter
    @Setter
    private int numRounds = 10;

    @ManyToOne
    @Getter
    @Setter
    @NotNull
    @JsonIdentityReference
    private Player leader;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    @JsonManagedReference
    private Map<Player, Stats> playerStats = new HashMap<>();

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private GameStatus gamestatus;

    @ManyToMany
    @Getter
    @Setter
    @JsonIdentityReference

    private Set<Player> readyPlayers = new HashSet<>();


}
