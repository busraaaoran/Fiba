package orm.relation.mvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import orm.relation.Player;
import orm.relation.Team;
import orm.relation.TeamRepository;

@Controller
@RequestMapping("/sports")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping("/team/insert")
	@ResponseBody
	public String insertTeam() {
		Team teamA = new Team(0,"Team A");
		teamA.setPlayerList(new ArrayList<>());
		
		Player player2 = new Player(0,"Han Jisung",63);
		player2.setTeam(teamA);
		teamA.getPlayerList().add(player2);
		
		Player player3 = new Player(0,"Joe Biden",73);
		player3.setTeam(teamA);
		teamA.getPlayerList().add(player3);
		
		teamRepository.save(teamA);
		
		return "Inserted : ";
	}
}
