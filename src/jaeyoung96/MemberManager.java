package jaeyoung96;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import jaeyoung96.AdminManager;

public class MemberManager {

		String id;      		// 회원ID
		String title;			// 자료명
		String rentInfo;		// 대여상태
		String rentalDate;		// 대여일#
		String returnDate;		// 반납예정일#
		String dateOfExtens;	// 연장기간#
		String overdue;			// 연체일#
		 
		
		// 날짜포멧
		SimpleDateFormat format= new SimpleDateFormat ("yyyy/ MM/ dd");
		Date today= new Date();
		// 시간 더하기
		Calendar cal = Calendar.getInstance();
		
		
		// 회원리스트, 자료리스트 불러오기
		AdminManager admManager=AdminManager.getInstance();
//		AdminManager member=AdminManager.getInstance();
//		AdminManager item=AdminManager.getInstance();
		
		
		// 대여 - 리스트 생성자 (회원ID, 자료 title)
		MemberManager(String id, String title, String rentalDate, String returnDate) {

			this.id=id;      				// 대여한 회원ID
			this.title=title;				// 대여한 자료명
			this.rentalDate=null; 			// 대여일
			this.returnDate=null;			// 반납일
			this.rentInfo="대여중";			// 대여상태
			this.dateOfExtens=null;			// 연장기간
			this.overdue=null;				// 연체기간
		}		
			

			
		// 대여 리스트 생성	
		ArrayList<MemberManager> rentalList=new ArrayList<>();
		
		
		
		
		
//		■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// 자료검색 ㅡ> 결과출력
		void showInfo() {
			
			 System.out.println("1.도서 | 2.DVD | 3. 게임");

             int selectNum = admManager.sc.nextInt();
             admManager.sc.nextLine();

             switch (selectNum) {
                 case 1:
                	System.out.println("찾으시는 자료명을 입력해주세요.");
                    String Title = admManager.sc.nextLine();
         			
         			int index = admManager.searchBookInfo(Title);
         			
         			if(index<0) {
         				System.out.println("검색하신 자료의 정보가 없습니다.");
         			} else {
         				System.out.println("------------------------");
         				admManager.getBooks().get(index).showBasicInfo();
         				System.out.println("------------------------");
         			}
                	 

                    System.out.println("1.상세정보 보기  | 2.대여 | 3.예약");
                    selectNum = admManager.sc.nextInt();
                    admManager.sc.nextLine();
                    
                    switch (selectNum) {
                        // 상세정보 보기 
                    	case 1:  
                             System.out.println("이곳에 상세 내역 출력");
                             admManager.showBookInfo();
                             System.out.println("1. 뒤로가기");
                             selectNum = admManager.sc.nextInt();
                             
                             
                             //비로그인 시
                             System.out.println("이용하시려면 로그인을 해 주세요.");
                             /* 로그인 메서드 */
                         
                    	// 대여
                    	case 2:  
                            //로그인 됬을시
                            /* 검색결과 메서드 */
                    		switch(selectNum) {
                         	case 1: 
                         		/* 대여 메서드 */
                         		break;
                         	case 2:
                         		/* 예약 메서드 */
                         		break;
                    		/* 대여 메서드 */
                        	 break;
                        	 
                        // 예약 	 
                        case 3:  
                        	/* 예약 메서드 */ 
                        	 break;
                        	 
                        
                    		}
                	 
                	 
                	 
                	 
                    }
             } 
                	 
                	 
            System.out.println("찾으시는 자료명을 입력해주세요.");
            String Title = admManager.sc.nextLine();
			
			int index = searchIndex(Title);
			
			if(index<0) {
				System.out.println("검색하신 자료의 정보가 없습니다.");
			} else {
				System.out.println("------------------------");
				admManager.itemList.get(index).showBasicInfo();
				System.out.println("------------------------");
			}
		} //showInfo() end
		
         
		 
		
		
		
		
		
		
		
		
		
		
		
		
//		■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// 자료검색 ㅡ> 인덱스 반환
		// 리스트 index 검색(렌탈리스트, 자료리스트) : 인스턴스의 자료명 기준
		int searchIndex(String title) {
			
			// 정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
			int searchIndex = -1;      // itemList Index
//			int searchIndex2 = -1; 		// rentalList Index
			
			// itemList에서 Title 검색해보기 (대여되지 않은 자료들)
			for(int i=0; i<admManager.itemList.size(); i++) {
				if(admManager.itemList.get(i).checkTitle(title))     //★★★★ RentalItemInfo 에 boolean checkTitle(String title) 메서드 만들기
					searchIndex=i;
					
				
				// 근데 이게 필요한가? 자료가 대여상태가지고 있으니..
				// rentalList에서 Title 검색해보기 (대여된 자료들) 
//				} else {
//					for(int j=0; j<rentalList.size(); j++) {
//						if(rentalList.get(i).checkTitle(tilte) {
//							searchIndex2=j;
//							return searchIndex2;
//						}
//					}
//				} //else end
					
			} //for end
			return searchIndex;
			
				
		} //searchIndex() end
		
		
			
		
		
		
		
//		■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// rentalList에 인스턴스 추가 
		void addRental(MemberManager info) {
			rentalList.add(info);
			
		}
		

		
		
//		■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// rentalList 인스턴스 생성
		void creatRentalList() {
			
			MemberManager info = null;
			
				// 대여할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
				String id =admManager.member.loginId(); // 로그인한 id
				String title=admManager.itemList.selecTitle();  // 자료선택한 title;
				
				// 대여일 생성
				String rentalDate=format.format(cal.getTime());
				System.out.println("대여일 : " + rentalDate);
				
				// 반납일 생성 : 대여일+7일
				cal.add(Calendar.DATE,7);
				String returnDate=format.format(cal.getTime());
				System.out.println("반납일 : "+returnDate);
	
				
	//			// 연장기간 : 대여일 +14일
	//			cal.add(Calendar.DATE,7);
	//			String dateOfExtens=format.format(cal.getTime());;	// 연장기간#
	//			System.out.println("연장일 : "+dateOfExtens);
	//			
	//			// 연체일 : 
	//			String overdue;			// 연체일#
				
				// 카운트 변경 
				admManager.member.rentalAvail -= 1;    // 회원정보 : 대여가능권수 -1
				admManager.member.numOfRent +=1;		// 회원정보 : 대여권수 +1
				admManager.itemList.numOfItem -=1;  	// 자료정보 : 재고 -1
				admManager.itemList.rentalCount +=1;	// 자료정보 : 대여횟수 +1
			
			// MemberManager 객체 생성
			info=new MemberManager(id, title, rentalDate, returnDate);
			
			
			// MemberManager 객체 ㅡ> 대여리스트에 추가 메서드 1-1. 호출.
			addRental(info); 
			System.out.println(id+"님 "+title+"자료가 대여가 완료되었습니다. ");
			
			
		}  // creatRentalList() end
		




//		■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// 예약
		void reserve() {
			System.out.println("예약하고자하는 자료명 입력해주세요.");
			String title = admManager.sc.nextLine();
			
			int index = searchIndex(title);
			
			if(index<0) {	 //예약 실패
				System.out.println("연장하고자하는 이름의 (책)가 없습니다.");
			}else {	// 예약일 생성
				Date reservDate=rentalList.get(index).returnDate;
				
				try {
					reservDate=format.parse("2020/ 05/ 05");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
				
				System.out.println(title+"이(가) "+ reservDate + "일자로 예약 되었습니다.");
				System.out.println(returnDate + " 까지 반납하세요.");
			}
		
		}	//reserve()	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public class Book extends RentalItemInfo{
			
			String author;		//저자
			int limitAge;		//제한연령
			String story;		//설명
			String launchDate;	//출판일
			String bestTitle;	//인기자료
			int rentalCount;	//대여횟수
			int like;			//관심수
			int numOfItem;		//재고
			String returnDate;	//반납예정일
		
		
		
		
		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		
		// 메서드 2 : 예약 ㅡ> 대여리스트에서 해당 인덱스 찾아서 예약처리.
		
		
		
		
		
		
		
		
		
		
		
			
		
		
		
	} //class end

