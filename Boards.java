public class Boards {
    private int board[][];
    final static int player1Symbol = 1;
	final static int player2Symbol = 2;
    public Boards(){
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}
    public void print() {
		int k = 0;
		for(int i = 0; i < 8; i++) {
			System.out.print(i+" | ");
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("   ----------------");
		System.out.print("    ");
		for(int i = 0; i<8 ; i++){
			System.out.print(i + " ");
		}
		System.out.println();
	}
    public boolean move(int symbol, int x, int y, player p1, player p2){
        int xd[] = {-1,-1,0,1,1,1,0,-1};
        int yd[] = {0,1,1,1,0,-1,-1,-1};
        if(x<0 || y<0 || x>=8 || y>=8 || board[x][y]!=0)
            return false;
        boolean overallCheck = false;
        for(int i = 0 ; i<8 ; i++){
            boolean check = false;
            int xStep = xd[i];
			int yStep = yd[i];
			int xx=x+xStep,yy=y+yStep;
			int count = 0;
			while(xx>=0 && yy>=0 && xx<8 && yy<8){
				if(board[xx][yy]!=symbol && board[xx][yy]!=0){
					xx+=xStep;
					yy+=yStep;
					count++;
				}else if(board[xx][yy]==symbol&&count>0){
					check = true;
                    overallCheck = overallCheck||check;
                    break;
				}else{
					check = false;
                    overallCheck = overallCheck||check;
                    break;
				}
			}
			if(check){
				xx=x;
				yy=y;
				int c = 0;
				while(c<=count){
					board[xx][yy] = symbol;
					xx+=xStep;
					yy+=yStep;
					c++;
					p1.count+=1;
				}
				p2.count-=count;
			}
        }
		return overallCheck;
    }
}
