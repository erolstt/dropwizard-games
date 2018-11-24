package games.db;

import games.core.Team;
import games.core.mapper.TeamMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TeamMapper.class)
public interface TeamDAO {

    @SqlQuery("select * from TEAM")
    List<Team> getAll();

    @SqlQuery("select * from TEAM where ID = :id")
    Team findById(@Bind("id") int id);

    @SqlUpdate("delete from TEAM where ID = :id")
    int deleteById(@Bind("id") int id);

    @SqlUpdate("update TEAM set NAME = :name where ID = :id")
    int update(@BindBean Team team);

    @SqlUpdate("insert into TEAM (ID, NAME) values (:id, :name)")
    int insert(@BindBean Team team);
}
