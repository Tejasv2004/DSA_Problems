class Solution {
    public int[] findErrorNums(int[] arr) {
        int[] ans = new int[2];
        int n = arr.length;
        int i =0;
        while(i < n){
            int idx = arr[i] - 1;
            if(arr[i] == i+1 || arr[idx] == arr[i])i++;
            else swap(arr,i,idx);
        }

        for(int j =0;j < n;j++){
            if(arr[j] !=  j +1){
                ans[0] = arr[j];
                ans[1] = j + 1;
            }
        }

        return ans;
    }

      public void swap(int[] arr,int i,int idx){
        int temp= arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }  
}