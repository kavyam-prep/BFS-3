import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class InvalidParenthesis{
    //bfs approach o(2^n)
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null ||  s.length() == 0) return result;
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);

        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                }else{
                    if(!flag){
                        for(int k = 0; k < curr.length(); k++){
                            if(Character.isAlphabetic(curr.charAt(k))){
                                continue;
                            }
                            String baby = curr.substring(0,k) + curr.substring(k+1);
                            if(!visited.contains(baby)){
                                visited.add(baby);
                                q.offer(baby);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public boolean isValid(String curr){
        int count = 0;
        for(char c: curr.toCharArray()){
            if(Character.isAlphabetic(c)){
                continue;
            }
            if(c == '('){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
}