package orm.relation.mvc;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import orm.relation.Player;
import orm.relation.PlayerRepository;


@Controller
@RequestMapping("/sports")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/player/byteam")
	@ResponseBody
	public String listTeamPlayers() {
		
		int teamId = 1;
		List<Player> players = playerRepository.findAllByTeamId(teamId);
		double totalScore = 0;
		for(Player player: players) {
			System.out.println(player.getPlayerId() + " "+
		player.getPlayerName() + " " +
					player.getAverageScore());
			
			totalScore+=player.getAverageScore();
		}
		double averageScore = totalScore/players.size();
		if(players.size()<=0) {
			return "There is no player in that team!";
		}
		
		return "Average Score of team: "+averageScore;
	}
}
