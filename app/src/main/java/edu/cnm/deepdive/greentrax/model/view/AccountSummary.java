package edu.cnm.deepdive.greentrax.model.view;

import androidx.room.ColumnInfo;
import androidx.room.DatabaseView;
import edu.cnm.deepdive.greentrax.model.entity.Account;

@DatabaseView(value = AccountSummary.QUERY, viewName = "account_summary")
  public class AccountSummary extends Account {

    //this is our query to our data base to show Game summaries
    static final String QUERY = "SELECT \n"
        + "  g.*, \n"
        + "  s.guess_count, \n"
        + "  (s.last_guess - s.first_guess) AS total_time \n"
        + "FROM \n"
        + "  game AS g \n"
        + "  INNER JOIN ( \n"
        + "    SELECT \n"
        + "      game_id, \n"
        + "      COUNT(*) AS guess_count, \n"
        + "      MIN(created) AS first_guess, \n"
        + "      MAX(created) AS last_guess \n"
        + "    FROM \n"
        + "      guess \n"
        + "    GROUP BY \n"
        + "      game_id \n"
        + "      \n"
        + "  ) AS s \n"
        + "     ON g.game_id = s.game_id\n";

    @ColumnInfo(name = "guess_count")
    private int guessCount;

    @ColumnInfo(name = "total_time")
    private long totalTime;

}
