package http.request

import java.sql.{ResultSet, DriverManager, Connection, Timestamp}
import java.text.SimpleDateFormat
import java.time.{ZoneId, LocalDateTime, Instant}
import java.time.format.DateTimeFormatter
import java.util.{Date, GregorianCalendar}

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import scalaj.http.Http

/**
  * Created by baohg on 7/23/16.
  */
object index {
  def get(url: String) = Http(url).asString

  def randBetween(start: Int, end: Int) {
  }

  def randDateOfBirth(): String = {
    val beginTime: String = "1960-01-01 00:00:00";
    val endTime: String = "1990-12-31 23:59:59";

    val beginTimestamp = Timestamp.valueOf(beginTime).getTime();
    val endTimestamp = Timestamp.valueOf(endTime).getTime();

    val diff = endTimestamp - beginTimestamp + 1;
    val randTimestamp = beginTimestamp + (Math.random() * diff).toLong;

    val dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    val randomDate = new Date(randTimestamp);
    dateFormat.format(randomDate)
  }

  def randomName(): String = {
    val response = get("http://www.behindthename.com/random/random.php?number=3&gender=u&surname=&all=no&usage_vie=1");
    val body = response.body;
    val doc: Document = Jsoup.parse(body);
    doc.select(".plain").text();

  }

  def connectMySQL() = {
    println("Mysql connector")
    // create database connection
    val dbc = "jdbc:mysql://localhost:3306/DBNAME?user=DBUSER&password=DBPWD"
    classOf[com.mysql.jdbc.Driver]
    val conn = DriverManager.getConnection(dbc)

    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

    // do database insert
    try {
      val prep = conn.prepareStatement("INSERT INTO quotes (quote, author) VALUES (?, ?) ")
      prep.setString(1, "Nothing great was ever achieved without enthusiasm.")
      prep.setString(2, "Ralph Waldo Emerson")
      prep.executeUpdate
    }
    finally {
      conn.close
    }
  }

  def connectPostgresSQL() = {
    println("Postgressql connector")

    // create database connection
    val dbc = "jdbc:postgresql://localhost:5432/DB_NAME?user=DB_USER"
    classOf[org.postgresql.Driver]

    val conn = DriverManager.getConnection(dbc)
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

    try {
      val prep = conn.prepareStatement("INSERT INTO quotes (quote, author) VALUES (?, ?) ")
      prep.setString(1, "Nothing great was ever achieved without enthusiasm.")
      prep.setString(2, "Ralph Waldo Emerson")
      prep.executeUpdate
    }
    finally {
      conn.close
    }
  }
}
//def insertData(conn:Connection, )
//  def main(args: Array[String]): Unit = {
//
//
//  }
//}
