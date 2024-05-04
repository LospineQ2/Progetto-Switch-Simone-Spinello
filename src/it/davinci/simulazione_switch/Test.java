package it.davinci.simulazione_switch;

import java.util.Vector;

public class Test
{
    public static void main(String[] args)
    {
        /*

            MAIN CON INSERIMENTO FRAME PRECEDENTE

         */
        Porta pA=new Porta("A");
        Porta pB=new Porta("B");
        int msg=100;
        int time=10;
        int j=0;

        Integer sommaCodaA[]={0,0,0};

        Integer sommaCodaB[]={0,0,0};

        for (int i=0;i<msg;i++)
        {
            Frame f=new Frame();
            if(f.getMac().equals("A"))pA.addFrame(f);
            else pB.addFrame(f);

        }
        pA.smistaPorta();
        pB.smistaPorta();

        while (j<time)
        {
            if (pA.uscitaPorta())
            {
                sommaCodaA[0] += pA.getP1size();
                sommaCodaA[1] += pA.getP2size();
                sommaCodaA[2] += pA.getP3size();
            }
            if (pB.uscitaPorta())
            {
                sommaCodaB[0] += pB.getP1size();
                sommaCodaB[1] += pB.getP2size();
                sommaCodaB[2] += pB.getP3size();
            }
            j++;
        }
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
