class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
        for(int i=0;i<n;i++){
            int s=0,e=n-1;
            while(s<e){
                int temp=image[i][s];
                image[i][s]=image[i][e];
                image[i][e]=temp;
                s++;
                e--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(image[i][j]==0){
                    image[i][j]=1;
                }else{
                    image[i][j]=0;
                }
            }
        }
        return image;
    }
}