package br.edu.insper.desagil.pi.tocha;

public class Filtro {
    private String tipo;
    private double[][] kernelMedia;
    private double[][] kernelSobelX;
    private double[][] kernelSobelY;
    private double[][] kernelLaplace;

    public Filtro(String tipo) {
        this.tipo = tipo;

        this.kernelMedia = new double[3][3];
        kernelMedia[0][0] = 0.111111;
        kernelMedia[0][1] = 0.111111;
        kernelMedia[0][2] = 0.111111;
        kernelMedia[1][0] = 0.111111;
        kernelMedia[1][1] = 0.111111;
        kernelMedia[1][2] = 0.111111;
        kernelMedia[2][0] = 0.111111;
        kernelMedia[2][1] = 0.111111;
        kernelMedia[2][2] = 0.111111;

        this.kernelSobelX = new double[3][3];
        kernelSobelX[0][0] = -1;
        kernelSobelX[0][1] = 0;
        kernelSobelX[0][2] = 1;
        kernelSobelX[1][0] = -2;
        kernelSobelX[1][1] = 0;
        kernelSobelX[1][2] = 2;
        kernelSobelX[2][0] = -1;
        kernelSobelX[2][1] = 0;
        kernelSobelX[2][2] = 1;

        this.kernelSobelY = new double[3][3];
        kernelSobelY[0][0] = -1;
        kernelSobelY[0][1] = -2;
        kernelSobelY[0][2] = -1;
        kernelSobelY[1][0] = 0;
        kernelSobelY[1][1] = 0;
        kernelSobelY[1][2] = 0;
        kernelSobelY[2][0] = 1;
        kernelSobelY[2][1] = 2;
        kernelSobelY[2][2] = 1;

        this.kernelLaplace = new double[3][3];
        kernelLaplace[0][0] = 0;
        kernelLaplace[0][1] = -1;
        kernelLaplace[0][2] = 0;
        kernelLaplace[1][0] = -1;
        kernelLaplace[1][1] = 4;
        kernelLaplace[1][2] = -1;
        kernelLaplace[2][0] = 0;
        kernelLaplace[2][1] = -1;
        kernelLaplace[2][2] = 0;
    }

    public Imagem processa(Imagem imagem) {
        if (tipo.equals("media")) {
            // inicializa saída

            int[][] entrada = imagem.getPixels();

            int altura = entrada.length;
            if (altura < 3) {
                throw new IllegalStateException("altura pequena");
            }

            int largura = entrada[0].length;
            if (largura < 3) {
                throw new IllegalStateException("largura pequena");
            }

            int[][] saida = new int[altura - 2][largura - 2];

            // inicializa kernel

            double[][] kernel = new double[3][3];
            kernel[0][0] = 0.111111;
            kernel[0][1] = 0.111111;
            kernel[0][2] = 0.111111;
            kernel[1][0] = 0.111111;
            kernel[1][1] = 0.111111;
            kernel[1][2] = 0.111111;
            kernel[2][0] = 0.111111;
            kernel[2][1] = 0.111111;
            kernel[2][2] = 0.111111;

            // calcula saída

            for (int y = 1; y < altura - 1; y++) {
                for (int x = 1; x < largura - 1; x++) {
                    double s = 0;
                    for (int dy = -1; dy < 2; dy++) {
                        for (int dx = -1; dx < 2; dx++) {
                            s += entrada[y + dy][x + dx] * kernel[dy + 1][dx + 1];
                        }
                    }
                    saida[y - 1][x - 1] = (int) s;
                }
            }

            return new Imagem(saida);
        } else if (tipo.equals("sobel_x")) {
            // inicializa saída

            int[][] entrada = imagem.getPixels();

            int altura = entrada.length;
            if (altura < 3) {
                throw new IllegalStateException("altura pequena");
            }

            int largura = entrada[0].length;
            if (largura < 3) {
                throw new IllegalStateException("largura pequena");
            }

            int[][] saida = new int[altura - 2][largura - 2];

            // inicializa kernel

            double[][] kernel = new double[3][3];
            kernel[0][0] = -1;
            kernel[0][1] = 0;
            kernel[0][2] = 1;
            kernel[1][0] = -2;
            kernel[1][1] = 0;
            kernel[1][2] = 2;
            kernel[2][0] = -1;
            kernel[2][1] = 0;
            kernel[2][2] = 1;

            // calcula saída

            for (int y = 1; y < altura - 1; y++) {
                for (int x = 1; x < largura - 1; x++) {
                    double s = 0;
                    for (int dy = -1; dy < 2; dy++) {
                        for (int dx = -1; dx < 2; dx++) {
                            s += entrada[y + dy][x + dx] * kernel[dy + 1][dx + 1];
                        }
                    }
                    saida[y - 1][x - 1] = (int) s;
                }
            }

            return new Imagem(saida);
        } else if (tipo.equals("sobel_y")) {
            // inicializa saída

            int[][] entrada = imagem.getPixels();

            int altura = entrada.length;
            if (altura < 3) {
                throw new IllegalStateException("altura pequena");
            }

            int largura = entrada[0].length;
            if (largura < 3) {
                throw new IllegalStateException("largura pequena");
            }

            int[][] saida = new int[altura - 2][largura - 2];

            // inicializa kernel

            double[][] kernel = new double[3][3];
            kernel[0][0] = -1;
            kernel[0][1] = -2;
            kernel[0][2] = -1;
            kernel[1][0] = 0;
            kernel[1][1] = 0;
            kernel[1][2] = 0;
            kernel[2][0] = 1;
            kernel[2][1] = 2;
            kernel[2][2] = 1;

            // calcula saída

            for (int y = 1; y < altura - 1; y++) {
                for (int x = 1; x < largura - 1; x++) {
                    double s = 0;
                    for (int dy = -1; dy < 2; dy++) {
                        for (int dx = -1; dx < 2; dx++) {
                            s += entrada[y + dy][x + dx] * kernel[dy + 1][dx + 1];
                        }
                    }
                    saida[y - 1][x - 1] = (int) s;
                }
            }

            return new Imagem(saida);
        } else if (tipo.equals("laplace")) {
            // inicializa saída

            int[][] entrada = imagem.getPixels();

            int altura = entrada.length;
            if (altura < 3) {
                throw new IllegalStateException("altura pequena");
            }

            int largura = entrada[0].length;
            if (largura < 3) {
                throw new IllegalStateException("largura pequena");
            }

            int[][] saida = new int[altura - 2][largura - 2];

            // inicializa kernel

            double[][] kernel = new double[3][3];
            kernel[0][0] = 0;
            kernel[0][1] = -1;
            kernel[0][2] = 0;
            kernel[1][0] = -1;
            kernel[1][1] = 4;
            kernel[1][2] = -1;
            kernel[2][0] = 0;
            kernel[2][1] = -1;
            kernel[2][2] = 0;

            // calcula saída

            for (int y = 1; y < altura - 1; y++) {
                for (int x = 1; x < largura - 1; x++) {
                    double s = 0;
                    for (int dy = -1; dy < 2; dy++) {
                        for (int dx = -1; dx < 2; dx++) {
                            s += entrada[y + dy][x + dx] * kernel[dy + 1][dx + 1];
                        }
                    }
                    saida[y - 1][x - 1] = (int) s;
                }
            }

            return new Imagem(saida);
        } else {
            throw new IllegalStateException("tipo inválido");
        }
    }
}
