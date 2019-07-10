package model;


import netcafe.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberModel {

    public Member findByUsernameAndStatus(String username,String password) {
        try {
            String sqlCommand = "select * from students where username = ? and status = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rsUsername = resultSet.getString("username");
                String rsPassword = resultSet.getString("password");

                String rsFullName = resultSet.getString("fullName");
                String rsAvatar = resultSet.getString("avatar");
                String rsremainTIme = resultSet.getString("remainTime");
                int rsStatus = resultSet.getInt("status");
                int rsRole = resultSet.getInt("role");
                int rsVipMember = resultSet.getInt("vipMember");
                System.out.println("rsVipMember:" + rsVipMember);
                Member member = new Member();
                member.setUsername(rsUsername);
                member.setPassword(rsPassword);
                member.setFullname(rsFullName);
                member.setAvatar(rsAvatar);
                member.setRemainTime(rsremainTIme);
                member.setStatus(String.valueOf(rsStatus));

                return member;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean save(Member member) {
        try {
            String sqlCommand = "insert into members (username, password, fullname, avatar, remainTime, status) ";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, member.getUsername());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getFullname());
            preparedStatement.setString(4, member.getAvatar());
            preparedStatement.setInt(5, member.getRemainTime());
            preparedStatement.setString(6, member.getStatus());

            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Member> getList() {
        ArrayList<Member> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from students";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String rsUsername = resultSet.getString("username");
                String rsPassword = resultSet.getString("password");
                String rsFullName = resultSet.getString("fullName");
                String rsAvatar = resultSet.getString("avatar");
                Integer rsRemainTime = resultSet.getInt("remaintime");
                String rsStatus = resultSet.getString("status");

                Member member = new Member();
                member.setUsername(rsUsername);
                member.setPassword(rsPassword);
                member.setFullname(rsFullName);
                member.setAvatar(rsAvatar);
                member.setRemainTime(String.valueOf(rsRemainTime));
                member.setStatus(rsStatus);

                results.add(member);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }
}
