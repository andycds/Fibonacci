package br.pro.software.fibonacci;

/**
 * Calcula o valor de fibonacci em tempo O log(n).
 * Técnica usada: exponenciação de matrizes.
 * @author Anderson Sanches
 * software.pro.br
 */
public class Fibonacci {
	
	public static void main(String[] args) {
		for (int i = 0; i <= 20; i++) {
			System.out.println(i + ": " + fibonacci(i));
		}
	}
	
	static void zerarMatriz(long matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = 0;
			}
		}
	}
	
	static long fibonacci(long n) {
	    long ans[][] = new long[2][2],
	            fibonacci[][] = {{1, 1}, {1, 0}},
	            result[][] = {{1, 0}, {0, 1}};
	    while (n > 0) {
	        if (n % 2 == 1) {
	        	zerarMatriz(ans);
	            for (int i = 0; i < 2; i++) {
	                for (int j = 0; j < 2; j++) {
	                    for (int k = 0;k < 2; k++) {
	                        ans[i][j] = (ans[i][j] + result[i][k] * fibonacci[k][j]);
	                    }
	                }
	            }
	            for (int i = 0; i < 2; i++) {
	                for (int j = 0; j < 2; j++) {
	                    result[i][j] = ans[i][j];
	                }
	            }
	        }
	        zerarMatriz(ans);
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                for (int k = 0; k < 2; k++) {
	                    ans[i][j] = (ans[i][j] + fibonacci[i][k] * fibonacci[k][j]);
	                }
	            }
	        }
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0;j < 2; j++) {
	                fibonacci[i][j] = ans[i][j];
	            }
	        }
	        n /= 2;
	    }
	    return result[0][1];
	}
}
