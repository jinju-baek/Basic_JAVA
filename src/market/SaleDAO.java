package market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.mybatis.SqlMapConfig;

public class SaleDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<SaleDTO> list;
	
	public int insertSale(HashMap<String, Object> map) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("sale.insert", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public void dashBoard() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("sale.dashBoard");
			int i = 0;
			int cnt = 0;
			int tprice = 0;
			System.out.println("■■ 번호\t제품명\t판매수량\t가격");
			for (SaleDTO line : list) {
				System.out.println("■■ " + (i+1) + "\t" + line.getSname() + "\t" + line.getCnt() + "\t" + line.getTprice());
				cnt += line.getCnt();
				tprice += line.getTprice();
				i++;
			}
			System.out.println("■■ 오늘 판매한 제품은 " + list.size() + "종류, " + "총 " + cnt + "개, 일일총판매액은 " + tprice + "원 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	
}
