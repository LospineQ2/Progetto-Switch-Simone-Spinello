package it.davinci.simulazione_switch;
import java.util.Random;

public class Test
{
    public static void main(String[] args)
    {
        Frame f;
        Random rand = new Random();
        Porta portaA=new Porta("A");
        Porta portaB=new Porta("B");
        int p=8,q;
        int time=10;
        int totalFrame=0;

        Integer sommaCodaA[]={0,0,0};

        Integer sommaCodaB[]={0,0,0};

        for (int i=0;i<time;i++)
        {
            for (int j=0;j<1+rand.nextInt(11);j++)//numero randomico di frame generati in un'unità di tempo
            {
                q=rand.nextInt(10)-p;
                if(q<=p)//probabilità esistenza di un frame
                {
                    f = new Frame();
                    if (f.getMac().equals("A")) portaA.addFrame(f);
                    else portaB.addFrame(f);
                    totalFrame++;
                }
            }
            portaA.smistaPorta();
            portaB.smistaPorta();

            if(portaA.uscitaPorta()){
                sommaCodaA[0]+= portaA.getP1size();
                sommaCodaA[1]+= portaA.getP2size();
                sommaCodaA[2]+= portaA.getP3size();
            }
            if(portaB.uscitaPorta()){
                sommaCodaB[0]+= portaB.getP1size();
                sommaCodaB[1]+= portaB.getP2size();
                sommaCodaB[2]+= portaB.getP3size();
            }
        }

        System.out.println("\nTotale pacchetti generati in "+time+" unità di tempo:"+totalFrame+"\n");


        System.out.println("Nella porta A");
        System.out.println("Lunghezza media in Buffer 3 (Maggiore Priorità): "+sommaCodaA[2]/time);
        System.out.println("Lunghezza media in Buffer 2: "+sommaCodaA[1]/time);
        System.out.println("Lunghezza media in Buffer 1 (Minore Priorità): "+sommaCodaA[0]/time);

        System.out.println("Nella porta B");
        System.out.println("Lunghezza media in Buffer 3 (Maggiore Priorità): "+sommaCodaB[2]/time);
        System.out.println("Lunghezza media in Buffer 2: "+sommaCodaB[1]/time);
        System.out.println("Lunghezza media in Buffer 1 (Minore Priorità): "+sommaCodaB[0]/time);

    }
}
