using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Aula9_Exemplo1
{
    class Program
    {
        static void Main(string[] args)
        {
            //Instrução para a criação do diretório Teste
            Directory.CreateDirectory(@"c:\Teste\");

            //Cria um objeto para manipular a escrita no arquivo
            StreamWriter wr = new StreamWriter(@"c:\Teste\Aula9_Exemplo1.txt", false);
            wr.WriteLine("Anonymous");
            wr.WriteLine("Vai ter Guerraaaa");
            wr.Close();

            //Cria um objeto para manipular a leitura do arquivo
            StreamReader rd = new StreamReader(@"c:\Teste\Aula9_Exemplo1.txt");
            while (!rd.EndOfStream)
            {
                string linha = rd.ReadLine();
                Console.WriteLine(linha);
            }
            rd.Close();

            Console.ReadKey();
        }
    }
}
