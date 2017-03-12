import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by Gleb88 on 12.03.2017.
 */
public class Main {

    public static void main(String agr[]){

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("file.txt"), StandardCharsets.UTF_8))){
            String line;
            INod expr=null;
            while ((line = reader.readLine()) != null) {
                expr = new Nod(line);
            }

            if(expr != null){
               System.out.println(expr.calculate());
            }

        } catch (IOException e) {

        }

    }
}
