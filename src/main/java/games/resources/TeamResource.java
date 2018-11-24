package games.resources;

import games.core.Team;
import games.db.TeamDAO;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teams")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TeamResource {

    TeamDAO teamDAO;

    public TeamResource(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @GET
    public List<Team> getAll(){
        return teamDAO.getAll();
    }

    @GET
    @Path("/{id}")
    public Team get(@PathParam("id") Integer id){
        return teamDAO.findById(id);
    }

    @POST
    public Team add(@Valid Team team) {
        teamDAO.insert(team);
        return team;
    }

    @PUT
    @Path("/{id}")
    public Team update(@PathParam("id") Integer id, @Valid Team team) {
        Team updateTeam = new Team(id, team.getName());
        teamDAO.update(updateTeam);
        return updateTeam;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        teamDAO.deleteById(id);
    }

}
