package market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.mybatis.SqlMapConfig;

public class SaleDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<ProductDTO> list;
	String sname;
	int cnt2;
	int tprice;
	SaleDTO sDto = new SaleDTO();
	
	// 판매 기록
	public void recordSale(int pno, int cnt) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = printPdt(pno, cnt);
			for(ProductDTO line : list) {
				sname = line.getPname();
				cnt2 = line.getCnt() * cnt;
				tprice = line.getPrice() * cnt;
			}
			HashMap<String, Object> map = new HashMap<>();
			map.put("sname", sname);
			map.put("cnt", cnt2);
			map.put("tprice", tprice);
			sqlSession.insert("sale.record", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 상품 목록 얻어오는 구문
	public List<ProductDTO> printPdt(int pno, int cnt) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("selectpdt", pno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
}
