import java.util.ArrayList;
import java.util.Collections;

public class MoveChooser {
  
    public static Move chooseMove(BoardState boardState){
        int best_value = -100000;
        int alpha = -999;
        int beta = 999;
        BoardState draft = boardState.deepCopy();
	    int searchDepth = Othello.searchDepth;
        ArrayList<Integer> max = new ArrayList<>();
        Move bestmove = null;
        ArrayList<Move> moves= boardState.getLegalMoves();
        if(moves.isEmpty()){
            return null;
        }
        for (Move move:moves){
            draft.makeLegalMove(move.x, move.y);
            int number = findalphabeta(draft,alpha,beta,searchDepth);
//            System.out.println("number"+number);
            if (number>best_value){
                best_value=number;
                bestmove = move;
//                System.out.println("best value"+best_value);
            }
        }
//
//
//
//
//
//
//
//        for (int i = 0;i< moves.size();i++){
//            BoardState draft2 = boardState.deepCopy();
//            draft2.makeLegalMove(moves.get(i).x,moves.get(i).y);
//            int alpha = findalphabeta(draft2,-9999,9999,searchDepth);
//            System.out.println("alpha"+alpha);
//            if (alpha>best_value){
//                best_value=alpha;
//                bestmove=moves.get(i);
//                System.out.println("best"+best_value);
//
//            }
//            else {
//                best_value=best_value;
//            }
//        }

        return bestmove;
//        best_value = Collections.max(max);

//        else {
//            for (int a = 0; a < max.size(); a++) {
//                if (max.get(a) == best_value) {
//                    return moves.get(a);
//
//                }
//
//            }
//        }

//        return moves.get(0);
    }
//    public static int findpossiblemoves(BoardState boardState) {
//        int alpha = -9999;
//        int beta = 9999;
//        int best_value;
//        int searchDepth = Othello.searchDepth;
//        BoardState draft = boardState.deepCopy();
//        ArrayList<Integer> value_get = new ArrayList<>();
//        ArrayList<Integer> temp_list = new ArrayList<>();
//        int[][] value_table1 = {
//                {120, -20, 20, 5, 5, 20, -20, 120},
//                {-20, -40, -5, -5, -5, -5, -40, -20},
//                {20, -5, 15, 3, 3, 15, -5, 20},
//                {5, -5, 3, 3, 3, -5, 5},
//                {5, -5, 3, 3, 3, 3, -5, 5},
//                {20, -5, 15, 3, 3, 15, -5, 20},
//                {-20, -40, -5, -5, -5, -5, -40, -20},
//                {120, -20, 20, 5, 5, 20, -20, 120}};
//        ArrayList<Move> fstmoves = draft.getLegalMoves();
//
//
//        for (Move move:fstmoves) {
//            int x = move.x;
//            int y = move.y;
//            value_get.add(value_table1[x][y]);//找到可落子的所有zhi
//        }
////        Collections.sort(value_get);
//        if (Othello.searchDepth == 0) {
//            return 0;//return 最后value
//        }
//        else if (draft.colour==1) {
//            for (int a = 0; a < value_get.size(); a++) {
//                int max_value = Collections.max(value_get);
//                if (value_get.get(a) ==max_value){
//                    fstmoves.get(a);
//                    searchDepth--;
//                    value_get.clear();
//                    findpossiblemoves(draft);
//                }


                //                if (alpha > max_value) {
//                    max_value = alpha;
//                    if (alpha > beta) {
//                        break;
//                    }
//                }
//                else {
//                    alpha = max_value;
//                    if (alpha > beta) {
//                        break;
//                    }
//
//                }
//                if (value_get.get(a) ==alpha){
//                    fstmoves.get(a);
////                    Count_value(draft,draft.colour);
//
//                    break;
//                }
////                return alpha;
//            }
//        }
////        else{
////            for (int a = 0; a < value_get.size(); a++) {
////                int minvalue = Collections.min(value_get);
////                if (value_get.get(a) ==minvalue){
////                    fstmoves.get(a);
////                    searchDepth--;
////                    value_get.clear();
////                    findpossiblemoves(draft);
//                }
////                int minvalue = value_get.get(0);
////                if (beta < minvalue) {
////                    beta = beta;
////                    if (alpha > beta) {
//                        break;
//                    }
//                }
//                else {
//                    beta = minvalue;
//                    if (alpha > beta) {
//                        break;
//                    }
//                }
//                if (value_get.get(a) ==alpha){
//                    fstmoves.get(a);
//                    Count_value(draft,draft.colour);
//                    break;
//                }
//
//            }
//        }
//            //
//    }
    public static int findalphabeta(BoardState draft, int alpha, int beta, int deepth){
        System.out.println("AlphaBeta search with depth " + deepth + ". " + alpha+" "+beta);
//        ArrayList<Integer> max = new ArrayList<>();
//        ArrayList<Integer> min = new ArrayList<>();
        BoardState draft1 = new BoardState();
        draft1=draft.deepCopy();
        if (deepth==0){
            return Count_value(draft1,draft1.colour);
        }
        ArrayList<Move> allmoves = draft1.getLegalMoves();
        if (allmoves.size()==0){
            return Count_value(draft, draft.colour);
        }
        for (int a=0;a<allmoves.size();a++){
//            BoardState draft1 = new BoardState();
//            draft1=draft.deepCopy();
            draft1.makeLegalMove(allmoves.get(a).x,allmoves.get(a).y);

            int score = findalphabeta(draft1, alpha, beta,deepth-1);
//            System.out.println("Score"+score);
            if (alpha>=beta){
//                max.clear();
//                min.clear();
                break;

            }
            if (draft1.colour==1){
//                int value = Count_value(draft1,1);
                if (score>alpha){
                    alpha=score;
//                    System.out.println("alp"+alpha);
//                    max.add(alpha);

                }
            }
            else {
                if (score<beta){
                    beta=score;
//                    min.add(beta);

                }
            }
//            if (alpha>=beta){
////                max.clear();
////                min.clear();
//                break;
//
//            }
//            max.clear();
//            min.clear();
        }

        if (draft.colour==1){//
//            return Collections.max(max);
//            System.out.println("Alpha"+alpha);
            return alpha;
        }
        else{
//            System.out.println("Beta"+beta);
            return beta;
//            return Collections.min(min);
        }
    }

    public static int Count_value(BoardState draft, int colour){
        int temp = 0;
        int[][] value_table = {
                {120, -20, 20, 5, 5, 20, -20, 120},
                {-20, -40, -5, -5, -5, -5, -40, -20},
                {20, -5, 15, 3, 3, 15, -5, 20},
                {5, -5, 3, 3, 3, 3,-5, 5},
                {5, -5, 3, 3, 3, 3, -5, 5},
                {20, -5, 15, 3, 3, 15, -5, 20},
                {-20, -40, -5, -5, -5, -5, -40, -20},
                {120, -20, 20, 5, 5, 20, -20, 120}};
        for (int a=0;a<8;a++ ){
            for (int b=0;b<8;b++){

                if (draft.getContents(a,b)==colour){
                    temp += value_table[a][b];
                }
                else if (draft.getContents(a,b)==-colour){
                    temp -= value_table[a][b];
                }
            }
        }
//        System.out.println("temp"+temp);
        return temp;
    }
}
