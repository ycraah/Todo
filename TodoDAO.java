package ycraah.myproject.jdbcex.dao;

import lombok.Cleanup;
import ycraah.myproject.jdbcex.domain.TodoVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {
  public String getTime(){
    String now = null;
    try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("select now()");
    ResultSet resultSet = preparedStatement.executeQuery();
    ) {
      resultSet.next();
      now = resultSet.getString(1);
    } catch(Exception e){
      e.printStackTrace();
    }
    return now;
  }

  public String getTime2() throws Exception {
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now() from dual");
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

    resultSet.next();

    String now = resultSet.getString(1);
    return now;
  }

  public void insert(TodoVO vo) throws Exception {
    String sql = "insert into tbl_todo (title, dueDate, finished) values(?, ?, ?)";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, vo.getTitle());
    preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
    preparedStatement.setBoolean(3, vo.isFinished());

    preparedStatement.executeUpdate();

  }

}
