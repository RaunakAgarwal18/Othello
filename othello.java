import java.util.Scanner;

public class othello {
    private player player1,player2;
    private Boards board;
    public static void main(String[] args) {
        othello o = new othello();
        o.startGame();
    }
    public void startGame(){
        Scanner sc = new Scanner(System.in);
        player1 = takeInput(1);
        player2 = takeInput(2);
        clearScreen();
        board = new Boards();
        board.print();
        boolean player1Turn = true;
        boolean status;
        int count = 4;
        while(count<=64){
            if(player1Turn){
                System.out.println("Player 1 - "+player1.getName()+"'s turn");
                System.out.println("Enter x: ");
                int x = sc.nextInt();
                System.out.println("Enter y: ");
                int y = sc.nextInt();
                if(x==-1 && y == -1){
                    player1Turn = false;
                    System.out.println("Player 1 - "+player1.getName()+" passed his turn");
                    continue;
                }
                status = board.move(1, x, y,player1,player2);
                if(!status){
                    System.out.println("Invalid Move!! Try again");
                }else{
                    player1Turn = false;
                    count++;
                    board.print();
                    System.out.println("Player 1 - "+player1.getName()+"'s score = "+player1.getCount());
                    System.out.println("Player 2 - "+player2.getName()+"'s score = "+player2.getCount());
                }
            }else if(!player1Turn){
                System.out.println("Player 2 - "+player2.getName()+"'s turn");
                System.out.println("Enter x and y coordinate: ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(x==-1 && y == -1){
                    player1Turn = true;
                    System.out.println("Player 1 - "+player1.getName()+" passed his turn");
                    continue;
                }
                status = board.move(2, x, y,player2,player1);
                if(!status){
                    System.out.println("Invalid Move!! Try again");
                }else{
                    player1Turn = true;
                    count++;
                    board.print();
                    System.out.println("Player 1 - "+player1.getName()+"'s score = "+player1.getCount());
                    System.out.println("Player 2 - "+player2.getName()+"'s score = "+player2.getCount());
                }
            }
        }
        if(player1.count>player2.count){
            System.out.println("Player 1 - "+player1.getName()+" wins");
        }else if(player1.count<player2.count){
            System.out.println("Player 2 - "+player2.getName()+" wins");
        }else{
            System.out.println("Match Draw !!!");
        }
        sc.close();
    }
    private player takeInput(int num){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player "+num+" name: ");
        String name = sc.nextLine();
        player p = new player(name,num);
        return p;
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
