package test;

public class CardGame {
	private String suit;
    private int rank;
    private int count;
    private boolean replay = false;
	
	public CardGame setCard(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
		return this;
	}
	
	public CardGame setCount(int count) {
		this.count = count;
		return this;
	}
	
	public CardGame setReplay(boolean replay) {
		this.replay = replay;
		return this;
	}

    public void playCard() {
    	
    	if (this.count == 0) {
    		System.out.println("게임 실행 실패: 게임은 1회 이상부터 실행할 수 있습니다.");
    		return;
    	}
    	
        // 카드와 카드의 게임 횟수를 가지고 play하는 로직이 들어간다고 가정
    	// 특정 상황에서 게임을 재실행 할지의 여부를 결정 (기본값 false)
    	// ex) card를 count번 ___한다.... ~~의 경우 게임을 재시작할지 replay를 통해 결정한다.
    	
    }

	public static void main(String[] args) {

		CardGame game = new CardGame();
		game.setCard("Spades", 1)
			.setCount(3)
			.setReplay(true);
		
		game.playCard();
        
	}
}
