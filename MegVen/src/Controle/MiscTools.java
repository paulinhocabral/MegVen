package Controle;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Um conjunto de fun��es est�ticas para apoiar o desenvolvimento de aplica��es
 */
public class MiscTools {
    public static boolean primo(int num) {
        boolean is = true;
        int conta = 2;
        while (conta <= (num/2) && is) {
            if (num % conta == 0) {
                is = false;
            }
            conta ++;
        }
        return(is);
    }
    
    public static boolean validarData( int d, int m, int a) {
        boolean correto = true;
        int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a%4 == 0 && (a%100 != 0 || a%400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m-1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarData( String data) {
        boolean correto = true;
        String newData = Formatacao.removerFormatacao(data);
        if(newData.length() == 8){
            int d = MiscTools.converterParaInteiro(newData.substring(0, 2));
            int m = MiscTools.converterParaInteiro(newData.substring(2, 4));
            int a = MiscTools.converterParaInteiro(newData.substring(4, 8));
            int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            if (a < 0 || m < 1 || m > 12) {
                correto = false;
            } else {
                // valida o dia
                if (a%4 == 0 && (a%100 != 0 || a%400 == 0)) {
                    dias[1] = 29;
                }
                if (d < 1 || d > dias[m-1]) {
                    correto = false;
                }
            }
        }
        else correto = false;
        return (correto);
    }
    
    public static int maiorDeTres(int a, int b , int c) {
        int maior;
        maior = Math.max( Math.max( a, b ), c );
        return(maior);
    }
    
    public static int fatorial(int num) {
        int fat=1;
        for (int x = 2; x <= num; x ++) {
            fat = fat * x;
            
        }
        return(fat);
    }
    
    public static boolean validaCpf( String cpf ) {
        boolean retorno = false;
        if(!cpf.trim( ).equals("")){
            int cpfAux = Integer.parseInt(cpf);
            int a,b,c,d,e,f,g,h,i,dv1,dv2,dv1_,dv2_;
            a = (int)(cpfAux/10000000000.0) % 10;
            b = (int)(cpfAux/1000000000) % 10;
            c = (int)(cpfAux/100000000) % 10;
            d = (int)(cpfAux/10000000) % 10;
            e = (int)(cpfAux/1000000) % 10;
            f = (int)(cpfAux/100000) % 10;
            g = (int)(cpfAux/10000) % 10;
            h = (int)(cpfAux/1000) % 10;
            i = (int)(cpfAux/100) % 10;
            dv1 = (int)((cpfAux/10) % 10);
            dv2 = (int)((cpfAux/1) % 10);

            /*a = Integer.parseInt(cpf, 0);
            b = Integer.parseInt(cpf, 1);
            c = Integer.parseInt(cpf, 2);
            d = (int)cpf.charAt(3);
            e = (int)cpf.charAt(4);
            f = (int)cpf.charAt(5);
            g = (int)cpf.charAt(6);
            h = (int)cpf.charAt(7);
            i = (int)cpf.charAt(8);
            dv1 = (int)cpf.charAt(9);
            dv2 = (int)cpf.charAt(10);*/

            dv1_ = (a*1 + b*2 + c*3 + d*4 + e*5 + f*6 + g*7 + h*8 + i*9) % 11;
            if (dv1_ == 10) {
                dv1_ = 0;
            }
            dv2_ = (a*0 + b*1 + c*2 + d*3 + e*4 + f*5 + g*6 + h*7 + i*8 + dv1_*9) % 11;
            if (dv2_ == 10) {
                dv2_ = 0;
            }
            if (dv1 == dv1_ && dv2 == dv2_) {
                retorno = true;
            }
        }

        else retorno = true;

        return (retorno);
    }
    
    public static int random( int li, int ls ) {
        int num;
        num = (int)(Math.random()*(ls-li+1)+li);
        return( num );
    }
    
    public static String gerarExtenso(int num) {
        int u,d;
        
        String extenso = "", conexao;
        String[] unidade,dezena,dezenaespecial;
        
        unidade        = new String[10];
        dezena         = new String[10];
        dezenaespecial = new String[10];
        
        unidade[0] = "";
        unidade[1] = "um";
        unidade[2] = "dois";
        unidade[3] = "tres";
        unidade[4] = "quatro";
        unidade[5] = "cinco";
        unidade[6] = "seis";
        unidade[7] = "sete";
        unidade[8] = "oito";
        unidade[9] = "nove";
        
        dezena[0] = "";
        dezena[1] = "dez";
        dezena[2] = "vinte";
        dezena[3] = "trinta";
        dezena[4] = "quarenta";
        dezena[5] = "cinquenta";
        dezena[6] = "sessenta";
        dezena[7] = "setenta";
        dezena[8] = "oitenta";
        dezena[9] = "noventa";
        
        dezenaespecial[0] = "dez";
        dezenaespecial[1] = "onze";
        dezenaespecial[2] = "doze";
        dezenaespecial[3] = "treze";
        dezenaespecial[4] = "quatorze";
        dezenaespecial[5] = "quinze";
        dezenaespecial[6] = "dezesseis";
        dezenaespecial[7] = "dezessete";
        dezenaespecial[8] = "dezoito";
        dezenaespecial[9] = "dezenove";
        
        if (num >= 1 && num <= 99) {
            d = num / 10;
            u = num % 10;
            
            conexao = "";
            if (d > 0 && u > 0) {
                conexao = " e ";
            }
            
            if (num >= 10 && num <= 19) {
                extenso = dezenaespecial[ u ];
            } else {
                extenso = dezena[ d ] + conexao + unidade[ u ];
            }
        }
        return (extenso);
    }
    
    
    public static int contarVogais(String x) {
        int c,v;
        String w;
        x = x.toLowerCase();
        w = "a�����e����i����o�����u����";
        v = 0;
        c = 0;
        while (c < x.length()) {
            if (w.indexOf( x.charAt(c) ) >= 0) {
                v ++;
            }
            c ++;
        }
        return ( v );
    }
    
    public static String inverterString( String f ) {
        int c;
        String x = "";
        
        c = f.length()-1;
        while (c >= 0) {
            x = x + f.charAt( c );
            c --;
        }
        return ( x );
    }
    
    public static boolean palindromo( String p1 ) {
        boolean retorno = false;
        if (p1.equals( inverterString(p1) ))  // p1 == p2
        {
            retorno = true;
        }
        return (retorno);
    }
    
    public static boolean palindromo( int n ) {
        return ( palindromo(n+"") );
    }
    
    /**
     * Espera um tempo para seguir adiante
     * @param segundos tempo de espera em segundos
     */
    public static void esperar( int segundos ) {
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {}
    }
    
    /**
     * Converte uma string para um n�mero inteiro
     * @param string string a ser convertida
     * @return n�mero inteiro
     */
    public static int converterParaInteiro( String string ) {
        int num = 0;
        try {
            num = Integer.parseInt( string );
        } catch (Exception e) {}
        return (num);
    }
    
    public static double converterParaReal( String string ) {
        double num = 0;
        try {
            num = Double.parseDouble( string );
        } catch (Exception e) {}
        return (num);
    }
    
    public static String converterRealParaString( double num ) {
        String string = String.valueOf(num);
        return (string);
    }
    
    public static String converterInteiroParaString( int num ) {
        String string = String.valueOf(num);
        return (string);
    }

    public static Date converteStringParaDate(String byData){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date dataConv = new Date();
        try{dataConv = (Date)format.parse(byData);}
        catch (Exception e){}
        return (dataConv);
    }

    public static int converterStringParaInteiro(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}