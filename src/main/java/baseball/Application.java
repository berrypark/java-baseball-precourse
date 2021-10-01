package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
	
	private static int computer1;
	private static int computer2;
	private static int computer3;
	
	private static int strike;
	private static int ball;
	private static int start=1;
	
    public static void main(String[] args) {
    	/*
    	 * Random, Scanner API대신 nextstep.utils 패키지에서 제공하는
    	 * Randoms, Console API를 활용해 구현해야 한다.
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
    	
    	makeNumber();

    	do {
    		System.out.print("숫자를 입력해주세요 : ");
        	String myNum = Console.readLine();
        	
        	if(checkInputNumber(myNum)) continue;
    		if(view(myNum)) {
    			reset();
    		}
    	} while(start == 1);
    }
    
    private static void makeNumber() {
		computer1 = Randoms.pickNumberInRange(1, 9);
    	computer2 = Randoms.pickNumberInRange(1, 9);
    	computer3 = Randoms.pickNumberInRange(1, 9);
    	
    	if(computer1 == computer2 || computer1 == computer3 || computer2 == computer3) {
    		makeNumber();
    	}
    	
    	System.out.println(computer1 + "" + computer2 + computer3);
    }
    
    private static boolean checkInputNumber(String input) {
    	if(!input.replaceAll("[+-]?\\d+","").equals("") || input.isEmpty() || ("").equals(input)) {
    		System.out.println("[ERROR] 숫자를 입력해주세요.");
    		return true;
    	}
    	if(input.length() > 3) {
    		System.out.println("[ERROR] 세자리 수를 입력해주세요.");
    		return true;
    	}
    	return false;
    }
    
    private static boolean view(String myNum) {
    	if(Integer.parseInt(myNum) - (computer1*100+computer2*10+computer3) == 0) {
    		System.out.println("3개의 숫자를 모두 맞히셨습니다!! 게임 끝");
    		return true;
    	}
    	compare(myNum);
    	if(strike>0) System.out.print(strike + "스트라이크");
    	if(ball>0) System.out.print(ball + "볼");
    	if(strike==0 && ball==0) System.out.print("낫싱");
    	clear();
    	return false;
    }
    
    private static void compare(String myNum) {
    	char[] arr = myNum.toCharArray();
    	for(int idx=0;idx<3;idx++) {
    		checkStrike(arr[idx], idx);
    		checkBall(arr[idx], idx);
    	}
    }
    
    private static int checkStrike(char c, int idx) {
    	if(idx == 0 && Character.getNumericValue(c) == computer1) strike++;
    	if(idx == 1 && Character.getNumericValue(c) == computer2) strike++;
    	if(idx == 2 && Character.getNumericValue(c) == computer3) strike++;
    	return strike;
    }
    
    private static int checkBall(char c, int idx) {
    	if(idx != 0 && Character.getNumericValue(c) == computer1) ball++;
    	if(idx != 1 && Character.getNumericValue(c) == computer2) ball++;
    	if(idx != 2 && Character.getNumericValue(c) == computer3) ball++;
    	return ball;
    }
    
    private static void clear() {
    	strike = 0;
    	ball = 0;
    	System.out.println();
    }
    
    private static void reset() {
    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
    	start = Integer.parseInt(Console.readLine());
    	if(start==1) makeNumber();
    }
}
