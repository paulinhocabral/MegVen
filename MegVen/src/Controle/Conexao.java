/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author paulo
 */
import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao
  extends Observable
{
  private String ip;
  private int porta;
  private String mensagem;

  public Conexao(String ip, int porta)
  {
    this.ip = ip;
    this.porta = porta;
    new Thread(new Recebe()).start();
  }

  public String getMensagem()
  {
    return this.mensagem;
  }

  public String getIp()
  {
    return this.ip;
  }

  public int getPorta()
  {
    return this.porta;
  }

  public void envia(String texto)
  {
    new Thread(new Envia(texto)).start();
  }

  public void notifica(String mensagem)
  {
    this.mensagem = mensagem;
    setChanged();
    notifyObservers();
  }

  class Recebe
    implements Runnable
  {
    byte[] dadosReceber = new byte['ÿ'];
    boolean erro = false;
    DatagramSocket socket = null;

    Recebe() {}

    public void run()
    {
      try
      {
        this.socket = new DatagramSocket(Conexao.this.getPorta());
      }
      catch (SocketException ex)
      {
        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
      }
      this.erro = false;
      while (!this.erro)
      {
        DatagramPacket pacoteRecebido = new DatagramPacket(this.dadosReceber, this.dadosReceber.length);
        try
        {
          this.socket.receive(pacoteRecebido);
          byte[] b = pacoteRecebido.getData();
          String s = "";
          for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) {
              s = s + (char)b[i];
            }
          }
          String nome = pacoteRecebido.getAddress().toString() + " disse:";
          Conexao.this.notifica(nome + s);
        }
        catch (Exception e)
        {
          System.out.println("erro");
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException ex)
          {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          }
          this.erro = true;
        }
      }
    }
  }

  class Envia
    implements Runnable
  {
    String texto;

    public Envia(String texto)
    {
      this.texto = texto;
    }

    public void run()
    {
      byte[] dados = this.texto.getBytes();
      try
      {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName(Conexao.this.getIp());
        DatagramPacket pacote = new DatagramPacket(dados, dados.length, addr, Conexao.this.getPorta());
        clientSocket.send(pacote);
        clientSocket.close();
      }
      catch (SocketException ex)
      {
        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (UnknownHostException ex)
      {
        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (IOException ex)
      {
        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}