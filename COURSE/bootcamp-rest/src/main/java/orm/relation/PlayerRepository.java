package orm.relation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
	
	@Query("select p from Player p where p.team.teamId =:teamId")
	List<Player> findAllByTeamId(@Param("teamId") int teamId);
}
