public class week {
    public static void main(String[] args){
        int key = 0;


    do{
            System.out.println(key);
            switch (key) {
                case 0:
                    System.out.println("月");
                    break;
                case 1:
                    System.out.println("火");
                    break;
                case 2:
                    System.out.println("水");
                    break;
                case 3:
                    System.out.println("木");
                    break;
                case 4:
                    System.out.println("金");
                    break;
                case 5:
                    System.out.println("土");
                    break;
                case 6:
                    System.out.println("日");
                    break;
                default:
                    break;
            }
            key++;
            
    }while(key <7);
    }
}