package fr.ynov.tdd.database;

public enum DatabaseEnum {
    DATABASE_NAME("hangmandb"),
    DATABASE_USER("hangmandb"),
    DATABASE_PASSWORD("hangmandb"),
    CREATE_TABLE_CATEGORY("CREATE TABLE IF NOT EXISTS Category(id IDENTITY PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50) NOT NULL)"),
    CREATE_TABLE_WORD("CREATE TABLE IF NOT EXISTS Word(value VARCHAR(50) NOT NULL, categoryId INT NOT NULL, FOREIGN KEY (CategoryId) REFERENCES Category(id))"),
    INSERT_DEFAULT_CATEGORY("INSERT INTO Category(name) VALUES('none') ON DUPLICATE KEY UPDATE name='none'"),
    SELECT_CATID_BY_NAME("SELECT id FROM Category WHERE name = ?"),
    INSERT_CARD_WITH_CAT("INSERT INTO Word(value, categoryId) VALUES(?,?)"),
    INSERT_CATEGORIE("INSERT INTO Category(name) VALUES (?)"),
    SELECT_WORDS_BY_CATID("SELECT value FROM Word WHERE categoryId = ?");

    public String value;

    public String getValue() {
        return this.value;
    }

    DatabaseEnum(String value) {
        this.value = value;
    }
}