import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sensitive {

    public static void main(String[] args){
        String[] arr = {"日本人","日本商人","天天向上"};
        Map mmap = createMap(arr);
        System.out.println(mmap);
        String check = "日普日本人拉斯哦附加费近乎疯狂的克莱斯天天向上勒水利建设因素日本商人人顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶";
        for(int i=0;i<check.length();i++){
            char letter = check.charAt(i);
            if(mmap.get(letter)!=null){
                circle(check,i,mmap);
            }

        }
    }
    private static int circle(String check,int start,Map map){

        Map tempMap = map;
        for(int i=start;i<check.length();i++){
            char letter = check.charAt(i);
            Map con = (Map)tempMap.get(letter);
            tempMap = con;
            if(con!=null){
                if("1".equals(con.get("isEnd"))){
                    System.out.println(check.substring(start, i+1));
                    System.out.println("i="+i);
                    System.out.println("start="+start);
                }
            }else{
                break;
            }
        }
        return 0;
    }


    private static Map createMap(String[] args){
        List<String> reList = Arrays.asList(args);
        Map finMap = new HashMap();
        Map temp = finMap;
        for(String name:reList){
            for(int i=0;i<name.length();i++){
                char letter = name.charAt(i);
                Map<Object, Object> newMap = new HashMap<Object, Object>();
                if(finMap.get(letter)==null){
                    if(i==name.length()-1){
                        newMap.put("isEnd", "1");
                    }else{
                        newMap.put("isEnd", "0");
                    }
                    finMap.put(letter, newMap);
                    if(i==name.length()-1){
                        finMap = temp;
                    }else{
                        finMap = newMap;
                    }
                }else{
                    finMap = (Map)finMap.get(letter);
                }
                //{日={本={商={人={isEnd=1}, isEnd=0}, 人={isEnd=1}, isEnd=0}, isEnd=0}, 天={天={向={上={isEnd=1}, isEnd=0}, isEnd=0}, isEnd=0}}
                //{日={本={商={人={isEnd=1}, isEnd=0}, 人={isEnd=1}, isEnd=0}, isEnd=0}, 天={天={向={上={isEnd=1}, isEnd=0}, isEnd=0}, isEnd=0}}
            }
        }
        return temp;
    }
}
