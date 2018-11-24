package games;

import games.core.Team;
import games.db.TeamDAO;
import games.resources.TeamResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class GamesApplication extends Application<GamesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GamesApplication().run(args);
    }

    @Override
    public String getName() {
        return "games";
    }

    @Override
    public void initialize(final Bootstrap<GamesConfiguration> bootstrap) {

        bootstrap.addBundle(new MigrationsBundle<GamesConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(GamesConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }


    @Override
    public void run(GamesConfiguration configuration, Environment environment) {
    final DBIFactory factory = new DBIFactory();
    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
    final TeamDAO teamDAO = jdbi.onDemand(TeamDAO.class);
    final TeamResource teamResource = new TeamResource(teamDAO);
    environment.jersey().register(teamResource);

    }
}
