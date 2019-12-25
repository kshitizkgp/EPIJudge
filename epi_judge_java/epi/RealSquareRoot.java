package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class RealSquareRoot {
  @EpiTest(testDataFile = "real_square_root.tsv")

  public static double squareRoot(double x) {
    double beg, en;
    if(x < 1.0){
      beg = x;
      en = 1.0;
      }
      else{//x>= 1.<9.
      beg = 1.0;
      en = x;
    }

    while(compare(beg, en) != 0){
      double mid = beg + (en - beg) * 0.5;
      double midsqr = mid * mid;
      if(compare(midsqr, x) > 0){
        en = mid;
      }
      else {
          beg = mid;
        }
    }
    return beg;
  }

  private static int compare(double a, double b){
    double EPSILON = 0.000001;
    double diff = (a - b) / b;

    if(diff < -EPSILON)
      return -1;

    if(diff > EPSILON)
      return 1;

    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RealSquareRoot.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
