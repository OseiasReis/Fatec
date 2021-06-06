using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Aula9_Exemplo3
{
    class Program
    {
        static void Main(string[] args)
        {
            string caminho = "c:\\Teste\\Aula9_Exemplo2.txt";

            //Cria Objetos
            System.IO.StreamReader sr;
            string linhaAtual;

            //Verifica se o Arquivo não Existe
            if (!System.IO.File.Exists(caminho)){
                throw (new System.IO.FileNotFoundException("Não foi Possivel Localizar o Arquivo Especificado"));
            }

            //Inicializa o StreamReader
            using (sr = new System.IO.StreamReader(caminho)){
                while (!sr.EndOfStream)
                {
                    //Recupera a Linha
                    linhaAtual = sr.ReadLine();
                    Console.WriteLine(linhaAtual);
                }
                Console.ReadKey();
            }
        }
    }
}
