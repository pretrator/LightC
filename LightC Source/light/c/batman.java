
package light.c;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class batman
{
    static char[][] d;
    
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()), a = 0; a < t; ++a) {
            for (int k = 0; k < 4; ++k) {
                final String st = br.readLine();
                for (int j = 0; j < 4; ++j) {
                    batman.d[k][j] = st.charAt(j);
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int l = 0; l < 4; ++l) {
                System.out.print(batman.d[i][l]);
            }
            System.out.println();
        }
    }
    
    static {
        batman.d = new char[4][4];
    }
}
