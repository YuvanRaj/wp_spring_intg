package com.springdev.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.commons.utils.ObjectUtils;


public class AbstractManagerDAO extends ObjectUtils implements DAOInterFace {
	private static final transient Logger logger = Logger.getLogger(AbstractManagerDAO.class);
	private DBConnectionUtility dbUtils;

	public DBConnectionUtility getDbUtils() {
		return dbUtils;
	}

	public void setDbUtils(DBConnectionUtility dbUtils) {
		this.dbUtils = dbUtils;
	}

	@Override
	public void insert(String sqlKey, Object objectInfo) {

	}

	@Override
	public boolean update(String sqlKey, Object objectInfo) {
		return false;
	}

	@Override
	public <T> List<T> select(String sqlKey, @SuppressWarnings("rawtypes") Class clazz, Object objectInfo) {
		Connection conn = null;
		ResultSet resultSet = null;
		Statement stmnt = null;
		String sql = null;
		List<T> result = null;
		try {
			conn = getDbUtils().createDBConnection();
			stmnt = conn.createStatement();
			resultSet = stmnt.executeQuery(sql);
			if (resultSet != null) {
				result = new ArrayList<T>();
				while (resultSet.next()) {
					T dbRef = null;
					result.add(dbRef);
				}
			}

		} catch (SQLException sqe) {
			logger.error("Error while executing select", sqe);
		} catch (Exception ex) {
			logger.error("Error while executing select", ex);
		} finally {
			if (conn != null) {
				getDbUtils().closeConnection(conn);
			}
		}
		return null;
	}

	@Override
	public boolean delete(String sqlKey, Object objectInfo) {
		return false;
	}

	@Override
	public long get_count(String sqlKey, Object objectInfo) {
		return 0;
	}

}
