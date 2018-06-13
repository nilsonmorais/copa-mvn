/*
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org>
 */
package br.estacio.prii.copa.entidade;

import br.estacio.prii.copa.utils.ErrorHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class TimeObject {

    private String group;
    private Integer rank;
    private String team;
    private Integer teamId;
    private Integer playedGames;
    private String crestURI;
    private Integer points;
    private Integer goals;
    private Integer goalsAgainst;
    private Integer goalDifference;

    public TimeObject(JSONObject time) {
        try {
            setGroup(time.getString("group"));
            setRank(time.getInt("rank"));
            setTeam(time.getString("team"));
            setTeamId(time.getInt("teamId"));
            setPlayedGames(time.getInt("playedGames"));
            setCrestURI(time.getString("crestURI"));
            setPoints(time.getInt("points"));
            setGoals(time.getInt("goals"));
            setGoalsAgainst(time.getInt("goalsAgainst"));
            setGoalDifference(time.getInt("goalDifference"));
        } catch (NumberFormatException | JSONException e) {
            ErrorHelper.showException(e.getMessage());
        }
    }

    public String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    public Integer getRank() {
        return rank;
    }

    private void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }

    private void setTeam(String team) {
        this.team = team;
    }

    public Integer getTeamId() {
        return teamId;
    }

    private void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    private void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public String getCrestURI() {
        return crestURI;
    }

    private void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public Integer getPoints() {
        return points;
    }

    private void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGoals() {
        return goals;
    }

    private void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    private void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    private void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

}
