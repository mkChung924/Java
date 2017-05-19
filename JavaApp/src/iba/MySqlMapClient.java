package iba;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MySqlMapClient {
	
	/*
	 * sqlMapConfig.xml(sql문을 포함한 XML등록)문서를 객체화 시켜주는 클래스
	 * *SqlMapClient 클래스: XML에 작성된 sql문을 호출.
	 */
	
	private static final SqlMapClient sqlMap;
	static{
		try {
			String resource = "./iba/sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("MySqlMapConfig초기화 중 에러: " + e);
		}
	}
	
	public static SqlMapClient getSqlMapInstance(){
		return sqlMap;
	}

}
