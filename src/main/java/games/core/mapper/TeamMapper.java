package games.core.mapper;

import games.core.Team;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements ResultSetMapper<Team> {

    public Team map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
    return new Team(resultSet.getInt("ID"), resultSet.getString("NAME"));
    }
}
