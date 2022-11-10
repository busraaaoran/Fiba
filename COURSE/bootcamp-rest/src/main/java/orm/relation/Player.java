package orm.relation;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerId;
	
	private String playerName;
	
	private double averageScore;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="team_id")
	private Team team;
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public Player() {
		
	}

	public Player(int playerId, String playerName, double averageScore) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.averageScore = averageScore;
	}
}
