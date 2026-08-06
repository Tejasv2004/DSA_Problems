class Solution {
    public void rotate(int[][] arr) {
      for(int i =0;i < arr.length;i++){
        for(int j =i+1; j < arr[0].length;j++){
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
        int stCol =0,endCol = arr[0].length-1;
        while(stCol <= endCol){
            int temp = arr[i][stCol];
            arr[i][stCol] = arr[i][endCol];
            arr[i][endCol] = temp;
            stCol++;
            endCol--;
        }
      } 
    }
}