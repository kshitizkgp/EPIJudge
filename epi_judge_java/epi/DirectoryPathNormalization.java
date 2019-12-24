package epi;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class DirectoryPathNormalization {
  @EpiTest(testDataFile = "directory_path_normalization.tsv")

  public static String shortestEquivalentPath(String path) {
    String[] arr = path.trim().split("/");
    Deque<String> dq = new LinkedList<>();
    for(String st:arr){
      if(st.equals("") || st.equals("."))
        continue;
      else
        if(st.equals("..")){
          if(!dq.isEmpty() && !dq.peekLast().equals("..")){
        dq.pollLast();
      }
      else{
        if(!path.startsWith("/")){
          dq.addLast("..");
        }
      }
    }
        else{
          dq.addLast(st);
        }
    }
    StringBuilder sb = new StringBuilder();
    if(path.startsWith("/")){
      sb.append("/");
    }
    while(!dq.isEmpty()){
      String st = dq.pollFirst();
      sb.append(st);
      if(!dq.isEmpty())
        sb.append("/");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DirectoryPathNormalization.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
