package array;

import java.util.HashMap;

public class CountCowsInArray {

    public static void main(String[] args) {
        int nums = 2;
        int size = 3;
        int cornerCows = 0;

        for(int i =0;i<nums;i++){

        }


        int[][] board = new int[size][size];
        board[0][0] = 1;
        board[1][0] = 1;
        for(int row = 0;row < board.length;row++){
            for(int col=0;col<board[row].length; col++){
                if(board[row][col] == 1){
                    cornerCows++;
                }
            }

        }
        System.out.println(cornerCows);

    }
}

class cowApi{


    public int getFieldSize(){
        return 3;
    }

    public int getNumberOfCows(){
        return 2;
    }

    public int getX(int index){
       return 1;
    }

    public int getY(int index){
return 1;
    }

    private void neighbours(int  col, int row) {

        //find all serouding cell by adding +/- 1 to col and row
        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {

                //if not the center cell
                if(! ((colNum == col) && (rowNum == row))) {

                    //make sure it is within  grid
                    if(withinGrid (colNum, rowNum)) {
                        System.out.println("Neighbor of "+ col+ " "+ row + " - " + colNum +" " + rowNum );
                    }
                }
            }
        }
    }

    //define if cell represented by colNum, rowNum is inside grid
//function used by neighbours()
    private boolean withinGrid(int colNum, int rowNum) {

        if((colNum < 0) || (rowNum <0) ) {
            return false;    //false if row or col are negative
        }
        if((colNum >= 3) || (rowNum >= 3)) {
            return false;    //false if row or col are > 75
        }
        return true;
    }

    private int countNeighbors(int[][] array, int yourX) {
        int[][] neighborRelationCount = new int[array.length][array[0].length];
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[y].length - 1; x++) {
                if (array[y][x] == yourX && array[y][x + 1] == yourX) {
                    neighborRelationCount[y][x]++;
                    neighborRelationCount[y][x + 1]++;
                }
            }
        }
        for (int y = 0; y < array.length - 1; y++) {
            for (int x = 0; x < array[y].length; x++) {
                if (array[y][x] == yourX && array[y + 1][x] == yourX) {
                    neighborRelationCount[y][x]++;
                    neighborRelationCount[y + 1][x]++;
                }
            }
        }
        int neighbourCount=0;
        for (int y = 0; y < neighborRelationCount.length; y++) {
            for (int x = 0; x < neighborRelationCount[y].length; x++) {
                if (0<neighborRelationCount[y][x]) {
                    neighbourCount++;
                }
            }
        }
        System.out.println(neighbourCount);
        return neighbourCount;
    }

    public static void main(String[] args) {

        for (int i =0; i<3; i++) {
             for (int j = i + 1; j < 3; j++) {
                 System.out.println("print");

            }
        }
        int[][] room = {
                {0, 0, 1, 1},
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 1, 0}
        };

        /*for(int i=0;i<room.length;i++) {
            for (int j = 0; j < room[i].length; j++) {
                new cowApi().neighbours(i,j);
            }
        }*/
        HashMap<Integer,Integer> xmap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> ymap = new HashMap<Integer,Integer>();
        int count =0;
        for(int i=0;i<room.length;i++){
            for(int j=0;j<room[i].length;j++){
                if(room[i][j] ==1){
                    xmap.put(count,i);
                    ymap.put(count,j);
                    count++;
                }

            }
        }
        int nums = 3;
        int size = 3;
int neighbours=0;
        for (int i = 0; i < nums; i++) {
            int x = xmap.get(i);
            int y = ymap.get(i);
            int neighbors = 0;

            for (int j = 0; j < nums; j++) {
                int xx = xmap.get(j);
                int yy = ymap.get(j);

                if ((Math.abs(x - xx) + Math.abs(y - yy) == 1)) {
                    neighbors++;
                }
            }

            System.out.println(neighbours);
        }
       /* for(int x=0;x<nums;x++){
            System.out.println(xmap.get(x) + "," +ymap.get(x));
            int xcord = xmap.get(x);
            int ycord = ymap.get(x);
            for(int k=x+1;k<nums;k++){
                int xcord1 = xmap.get(k);
                int ycord1 = ymap.get(k);
                // left
                if(xcord >= 0 && x-1 >= 0 && xcord == xcord1 && ycord -1 == ycord1){
                    neighbours++;
                }

            }
        }*/
        new cowApi().countNeighbors(room,1);
        /*for (int x = 0; x < nums; x++) {
            new cowApi().countNeighbors(room,1);
        }*/
        System.out.println("--------------------------");
        for (int x = 0; x < nums; x++) {
            System.out.println(xmap.get(x) + "," + ymap.get(x));
            int xcord = xmap.get(x);
            int ycord = ymap.get(x);
            new cowApi().neighbours(xcord, ycord);
            int xcordLeft = x - 1 >= 0 ? xmap.get(x - 1) : 0;
            int ycordLeft = x - 1 >= 0 ? ymap.get(x - 1) : 0;

            int xcordRight = x + 1 < size ? xmap.getOrDefault(x + 1, 0) : 0;
            int ycordRight = x + 1 < size ? ymap.getOrDefault(x + 1, 0) : 0;

            int xcordTop = xcord - 1 >= 0 ? xmap.get(xcord - 1) : 0;
            int ycordTop = ymap.get(ycord);

            /*int xcordBottom = xcord-1 >= 0 ? xmap.get(xcord-1) : 0 ;
            int ycordBottom = ymap.get(ycord);*/
            //left
            if (xcord >= 0 && x - 1 >= 0 && xcord == xcordLeft && ycord - 1 == ycordLeft) {
                System.out.println("left");
                neighbours++;
            }
            //right
            if (xcord >= 0 && x + 1 < size && xcord == xcordRight && ycord + 1 == ycordRight) {
                System.out.println("right");
                neighbours++;
            }
            //top
            if (xcord >= 0 && xcord - 1 >= 0 && xcord - 1 == xcordTop && ycord == ycordTop) {
                System.out.println("top");
                neighbours++;
            }

            //bottom
        }
        System.out.println(neighbours);

        /*int counter = 0;

        int rowLimit = arr.length;
        int colLimit = arr[0].length;

        for (int r = 0; r < rowLimit; r++)
        {
            for (int c = 0; c < colLimit; c++)
            {
                if ((c+1 < colLimit) && (arr[r][c] == arr[r][c+1]) && arr[r][c]==1)
                    counter = counter +1;

                if ((r+1 < rowLimit) && (arr[r][c] == arr[r+1][c]) && arr[r][c]==1)
                    counter = counter +1;

                if ((c+1 < colLimit) && (arr[r][c] == arr[r][c-1]) && arr[r][c]==1)
                    counter = counter +1;

                if ((r+1 < rowLimit) && (arr[r][c] == arr[r-1][c]) && arr[r][c]==1)
                    counter = counter +1;
            }
        }
        System.out.println(counter);*/


    }


}
