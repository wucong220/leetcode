package contest;

import java.time.LocalDate;
import java.util.List;

public class P1 {
    public int superEggDrop(int K, int N) {

    	return (int) Math.log(N);
    }

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2020, 2, 20);
        LocalDate localDate1 = LocalDate.of(2020, 2, 20);
        System.out.println(localDate==localDate1);
    }
}
