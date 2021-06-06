using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Aula9_Exemplos4
{
    class Program
    {
        static void Main(string[] args)
        {
            //Instanciando as Variaveis
            int idade = 25;
            string nome = "Sérgio";
            bool temFilhos = false;
            double altura = 1.79;

            //criando o arquivo
            FileStream stream = new FileStream(@"C:\\Teste\\Aula9_Exemplo4.bin", FileMode.Create);

            //Instanciando a variavel do tipo BinaryWriter
            BinaryWriter writer = new BinaryWriter(stream);

            //Usando o método Write para escrever no arquivo.
            writer.Write(idade);
            writer.Write(nome);
            writer.Write(temFilhos);
            writer.Write(altura);

            writer.Flush();
            writer.Close();
        }
    }
}
