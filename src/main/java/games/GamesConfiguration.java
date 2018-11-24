package games;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GamesConfiguration extends Configuration {
   @Valid
   @NotNull
   @JsonProperty("database")
   private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
       return database;
   }
}
