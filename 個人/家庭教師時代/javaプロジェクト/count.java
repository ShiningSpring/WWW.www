
public class count {
    public static void main(String[] args){

        for (int i = 1;i > -1;i--){
            //System.out.println(i);





        }
        int[] a = {1,2,3,4,5};
        loop1:
        for (int j = 0;j < 10;j++){
        for(int k : a){
            

            if (k < 3){
                continue;

            }
            if (k == 4){
                break loop1;
            }   
            System.out.println(j+"," +k);
        }
        
            
        }


    }}
