package MyPackage;


class Base4{
private void amethod(int iBase){
        System.out.println("Base.amethod");
        }
}



public class Over extends Base4{

public static void main(String argv[]){
        Over o = new Over();
        int iBase=0;
        o.amethod(iBase);
        }
        public void amethod(int iOver){
                System.out.println("Over.amethod");
        }

}
