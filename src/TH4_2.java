public class TH4_2 {
    public static void main(String[] args) {
        int i, n, j, bangcc;
        n = 10;
        for (i=1; i<n; i++){
            System.out.println("Bảng cửu chương "+i);
            for (j=1; j<=n; j++){//(Văn Vũ đã sửa)
                    bangcc = i*j;
                System.out.println(i+"*"+j+" = "+bangcc);
            }
            System.out.println("----");
        }
    }
}
