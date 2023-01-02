package org.csu.webJpetStore.persistence.Impl;

import org.csu.webJpetStore.persistence.BannerDataDAO;
import org.csu.webJpetStore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BannerDataDAOImpl implements BannerDataDAO {
    public static final String Search=
            "SELECT BANNERNAME FROM BANNERDATA WHERE FAVCATEGORY =?";

    @Override
    public String SearchBannerNameByFavcategory(String favcategory) {
        String bannername=null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(Search);
            preparedStatement.setString(1,favcategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                bannername=resultSet.getString("bannername");
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatent(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return bannername;
    }
}
