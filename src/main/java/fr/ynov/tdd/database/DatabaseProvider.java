package fr.ynov.tdd.database;

import fr.ynov.tdd.domain.DatabaseEnum;
import fr.ynov.tdd.domain.Statistic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseProvider {
    final Properties PROPERTIES;

    String connectionURL;
    Connection connection;

    public DatabaseProvider(boolean shouldCreateDbInMemory) {
        PROPERTIES = new Properties();
        PROPERTIES.put("user", DatabaseEnum.DATABASE_USER.getValue());
        PROPERTIES.put("password", DatabaseEnum.DATABASE_PASSWORD.getValue());

        if (shouldCreateDbInMemory) {
            connectionURL = String.format("jdbc:h2:mem:%s;mode=MySQL;mv_store=false", DatabaseEnum.DATABASE_NAME.getValue());
        } else {
            connectionURL = String.format("jdbc:h2:./%s;mode=MySQL;mv_store=false", DatabaseEnum.DATABASE_NAME.getValue());
        }
    }

    public void initDatabase() {
        try {
            connection = DriverManager.getConnection(connectionURL, PROPERTIES);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(DatabaseEnum.CREATE_TABLE_CATEGORY.getValue());
            stmt.executeUpdate(DatabaseEnum.CREATE_TABLE_WORD.getValue());
            stmt.executeUpdate(DatabaseEnum.CREATE_TABLE_STATISTIC.getValue());
            stmt.executeUpdate(DatabaseEnum.INSERT_DEFAULT_CATEGORY.getValue());
            stmt.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public void addCategory(String catName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DatabaseEnum.INSERT_CATEGORIE.getValue());
            preparedStatement.setString(1, catName);
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public int getCatIdByName(String catName) {
        int id = -1;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DatabaseEnum.SELECT_CATID_BY_NAME.getValue());
            preparedStatement.setString(1, catName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return id;
    }

    public void addWords(ArrayList<String> words, int catId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DatabaseEnum.INSERT_CARD_WITH_CAT.getValue());

            for (String word : words) {
                preparedStatement.setString(1, word);
                preparedStatement.setInt(2, catId == -1 ? 1 : catId);
                preparedStatement.execute();
            }

            preparedStatement.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public ArrayList<String> getWordsByCatId(int catId) {
        ArrayList<String> words = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DatabaseEnum.SELECT_WORDS_BY_CATID.getValue());
            preparedStatement.setInt(1, catId == -1 ? 1 : catId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                words.add(resultSet.getString("value"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return words;
    }

    public void addStatisticsAtEndGame(Statistic statistic) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DatabaseEnum.INSERT_STATISTIC.getValue());

            preparedStatement.setString(1, statistic.getWordToFind());
            preparedStatement.setBoolean(2, statistic.haveFoundWord());
            preparedStatement.setInt(3, statistic.getTryCount());
            preparedStatement.setDate(4, new java.sql.Date(statistic.getDate().getTime()));
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public ArrayList<Statistic> getAllStatistics() {
        ArrayList<Statistic> statistics = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DatabaseEnum.GET_STATISTICS.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                statistics.add(new Statistic(
                        resultSet.getString("word"),
                        resultSet.getBoolean("found"),
                        resultSet.getInt("tryCount"),
                        resultSet.getDate("date")
                ));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return statistics;
    }
}
