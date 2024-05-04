package it.davinci.simulazione_switch;

import java.util.Vector;

public class Porta
{
    private String nome;
    private Vector<Frame> codaPorta;
    private Vector<Frame> p1;
    private Vector<Frame> p2;
    private Vector<Frame> p3;


    public Porta(String nome)
    {
        this.nome = nome;
        this.codaPorta = new Vector<Frame>();
        this.p1=new Vector<Frame>();
        this.p2=new Vector<Frame>();
        this.p3=new Vector<Frame>();
    }

    public String getNome()
    {
        return nome;
    }

    public int getP1size()
    {
        return this.p1.size();
    }

    public int getP2size()
    {
        return this.p2.size();
    }

    public int getP3size()
    {
        return this.p3.size();
    }

    public boolean addFrame(Frame f){
        if(this.codaPorta.add(f))return true;
        return false;
    }
    public boolean smistaPorta(){
        if(this.codaPorta==null)return false;
        if(this.codaPorta.isEmpty())return false;
        while (!this.codaPorta.isEmpty())
        {
            if (this.codaPorta.firstElement().getPriorita().equals(3))
            {//priorita 3
                this.p3.add(this.codaPorta.firstElement());
                this.codaPorta.remove(this.codaPorta.firstElement());
            }
            else if (this.codaPorta.firstElement().getPriorita().equals(2))
            {//priorita 2
                this.p2.add(this.codaPorta.firstElement());
                this.codaPorta.remove(this.codaPorta.firstElement());
            }
            else
            {    //priorita 1
                this.p1.add(this.codaPorta.firstElement());
                this.codaPorta.remove(this.codaPorta.firstElement());
            }
        }
        return true;
    }
    public boolean uscitaPorta() {

        // Rimuovi un frame dalla coda p3
        if (!this.p3.isEmpty()) {
            this.p3.remove(0);
            return true;
        }

        // Rimuovi un frame dalla coda p2 solo se non è stato rimosso un frame da p3
        if (!this.p2.isEmpty()) {
            this.p2.remove(0);
            return true;
        }

        // Rimuovi un frame dalla coda p1 solo se non è stato rimosso un frame da p3 o p2
        if (!this.p1.isEmpty()) {
            this.p1.remove(0);
            return true;
        }

        return false;
    }


}
