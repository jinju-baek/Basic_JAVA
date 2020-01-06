package market;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.mybatis.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	boolean flag; // default : false

	// 제품 전체 조회(재고 > 1)
	public List<ProductDTO> selelctUsePdt() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.selectUsePdt");
			printPdt(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	// 상품 판매시 재고를 마이너스하는 함수
	public void cntMinusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("pname", pname);
			map.put("cnt", cnt);
			map.put("flag", "minus");
			sqlSession.update("pdt.cntChange", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 기존에 등록된 제품인지 최초 입고 제품인지 판별
	public boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("pdt.already", pname);
			if (result > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}

	// 제품 수량 변경
	public void cntPlusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("pname", pname);
			map.put("cnt", cnt);
			map.put("flag", "plus");
			result = sqlSession.update("pdt.cntChange", map);

			if (result > 0) {
				System.out.println("■■ 입고 성공!");
			} else {
				System.out.println("■■ 입고 실패. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	// 제품 등록
	public void insertPdt(String pname, String company, int price, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("pname", pname);
			map.put("company", company);
			map.put("price", price);
			map.put("cnt", cnt);
			result = sqlSession.insert("pdt.insert", map);

			if (result > 0) {
				System.out.println("■■ 등록 성공!");
			} else {
				System.out.println("■■ 등록 실패. 관리자에게 문의해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	// 제품 삭제
	public void deletePdt(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("pdt.delete", pname);
			if (result > 0) {
				System.out.println("■■ 삭제 성공!");
			} else {
				System.out.println("■■ 삭제 실패. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	// 제품 조회
	public void selectPdt() {
		 sqlSession = sqlSessionFactory.openSession(); 
		 try { 
			 list = sqlSession.selectList("pdt.select"); 
			 printPdt(list);
		 } catch (Exception e) { 
			 e.printStackTrace(); 
		 } finally { 
			 sqlSession.close();
		 }
	}

	// 제품 검색
	public void searchPdt(String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.search", keyword);
			System.out.println("■■" + keyword + "(으)로 검색한 결과 총 " + list.size() + "건이 나왔습니다.");
			printPdt(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// select문 결과 출력
	public void printPdt(List<ProductDTO> list) {
		int i = 1;
		System.out.println("번호\t제품번호\t제품명\t제조회사\t가격\t수량\t입고일");
		for (ProductDTO line : list) {
			System.out.println(i + "\t" + line.getPno() + "\t" + line.getPname() + "\t" + line.getCompany() + "\t"
					+ line.getPrice() + "\t" + line.getCnt() + "\t" + line.getRegdate());
			i++;
		}
	}

	


}
