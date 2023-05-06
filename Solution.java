import java.util.*;
class NetworkConnectivity {
    public static int[] bestCoordinate(int[][] towers, int radius) {
        int res[] = new int[2];
        double maxQuality = 0;
        double quality = 0;
        int finalX = 0;
        int finalY = 0;
        for(int i=0; i<51; i++) {
            for(int j=0; j<51; j++) {
                quality = 0;
                for(int[] tower: towers) {
                    int x = tower[0]-i;
                    int y = tower[1]-j;
                    double dist = Math.sqrt(x*x+y*y); 
                    if(dist <= radius) quality += Math.floor(tower[2]/(1+dist));
                }
                if(maxQuality < quality) {
                    maxQuality = quality;
                    finalX = i;
                    finalY = j;
                }
            }
        }
        res[0] = finalX;
        res[1] = finalY;
        return res;
    }
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the number of towers");
    	int n = sc.nextInt();
    	int[][] arr = new int[n][3];
    	System.out.println("Enter coordinates of towers and their signal quality");
    	for(int i = 0;i < n;i++) {
    		for(int j = 0;j < 3;j++) {
    			arr[i][j] = sc.nextInt();
    		}
     }
    	System.out.println("Enter radius");
    	int radius = sc.nextInt();
    	int[] result = bestCoordinate(arr, radius);
    	System.out.println(Arrays.toString(result));
    }
}   

Sample Input/Output 

Input: towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
Output: [2,1]

Input: towers = [[23,11,21]], radius = 9
Output: [23,11]


Input: towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
Output: [1,2]
