package it.davinci.simulazione_switch;
import java.util.Random;
public class Frame
{
    private String mac;
    private Integer priorita;

    public Frame()
    {
        Random rand = new Random();

        //generazione destinazione mac
        int mac= rand.nextInt(2);
        if(mac==0)//destinazione = A;
            this.mac = "A";
        else this.mac = "B";//destinazione = B

        //generazione priorita
        this.priorita=1+rand.nextInt(3);//priorita 1/2/3

    }

    public String toString()
    {
        String str="\n-*Frame*-";
        str+="\nMac: "+this.mac;
        str+="\nPriorità: "+this.priorita;
        str+="\n------------------------";

        return str;
    }

    public String getMac()
    {
        return this.mac;
    }

    public Integer getPriorita()
    {
        return this.priorita;
    }


}
