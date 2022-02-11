package se.studiegrupp7.listaHighscore;

import java.time.LocalDateTime;

public class TournamentStats {
    String name;
    int score;
    LocalDateTime localDateTime;

    public TournamentStats(String name, int score, LocalDateTime localDateTime) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return "TournamentStats{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
