package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
    	/*
    	 * Random, Scanner API대신 nextstep.utils 패키지에서 제공하는
    	 * Randoms, Console API를 활용해 구형해야 한다.
    	 * 
    	 * Random 값 추출은 nextstep.utils.Randoms의 pickNumberInRange()를 활용한다.
    	 * 사용자가 입력하는 값은 nextstep.utils.Console의 readLine()을 활용한다.
    	 * 
    	 * 프로그램 구현을 완료했을 때 src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
    	 * 
    	 * 람다 사용 가능, stream api 사용 불가능
    	 * else 예약어 사용 불가능 return으로 구현
    	 * 
    	 * 함수길이 10라인 안넘어가도록 구현
    	 * 
    	 * */
    	int computer = makeNumber();
    	
    	while(checkNumber(computer)) {
    		computer = makeNumber();
    	}

    	
    	System.out.println("숫자를 입력해주세요 : " + computer);
    	Console.readLine();

    }
    
    private static boolean checkNumber(int org) {
    	if((org+"").contains("0")) {
    		return true;
    	}    	
    	return false;
    }
    
    private static int makeNumber() {
    	return Randoms.pickNumberInRange(111, 999);
    }
}
