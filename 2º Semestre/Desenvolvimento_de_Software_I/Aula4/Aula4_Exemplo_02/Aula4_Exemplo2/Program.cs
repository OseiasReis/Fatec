using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula4_Exemplo2
{
    class Program
    {
        static void Main(string[] args)
        {
            string palavra;
            int i;

            Console.Write("Digite uma palavra: ");
            palavra = Console.ReadLine();

            Console.WriteLine("\nVogais da Palavra: {0} \n", palavra);

            char[] vetor = palavra.ToCharArray();

            int tamanho = vetor.Length;

            for (i = 0; i < tamanho; i++)
            {
                if (vetor[i] == 'a' || vetor[i] == 'e' || vetor[i] == 'i' || vetor[i] == 'o' || vetor[i] == 'u')
                    Console.Write(" {0}", vetor[i]);
            }

            Console.WriteLine("\n\n\nConsoantes da Palavra: {0} \n", palavra);

            for (i = 0; i < tamanho; i++)
            {
                if (vetor[i] == 'b' || vetor[i] == 'c' || vetor[i] == 'd' || vetor[i] == 'f' || vetor[i] == 'g' || vetor[i] == 'h' || vetor[i] == 'j' || vetor[i] == 'k' || vetor[i] == 'l' || vetor[i] == 'm' || vetor[i] == 'n' || vetor[i] == 'p' || vetor[i] == 'q' || vetor[i] == 'r' || vetor[i] == 's' || vetor[i] == 't' || vetor[i] == 'v' || vetor[i] == 'w' || vetor[i] == 'x' || vetor[i] == 'y' || vetor[i] == 'z')
                    Console.Write(" {0}", vetor[i]);
            }

            Console.ReadKey();
            

        }
    }
}
