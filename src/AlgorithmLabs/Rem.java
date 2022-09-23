package AlgorithmLabs;

public class Rem {
    public long div(long n, long m){
        long divisor = (long) Math.pow(10,m);
        long quotient = 0;
        while(n >= divisor){
            quotient++;
            n -= divisor;
        }

        return quotient;
    } // div

    public long rem(long n, long m){
        long divisor = (long) Math.pow(10,m);
        long quotient = this.div(n,m);

        return n-divisor*quotient;
    }
}
