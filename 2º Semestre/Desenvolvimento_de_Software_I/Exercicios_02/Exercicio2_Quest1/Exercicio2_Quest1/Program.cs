using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio2_Quest1
{
    class Program
    {
        static void Main(string[] args)
        {
            string nome;
            float nota1, nota2, media;

            Console.Write("Digite seu Nome: ");
            nome = Console.ReadLine();

            float nota = LerNota(nota1, nota2);
            float media = calcularMedia(media);
            Console.ReadKey();
        }

        static float LerNota (float nota1, nota2)
        {
            Console.Write(nome + " Digite a Primeira Nota: ");
            nota1 = float.Parse(Console.ReadLine());

            Console.Write(nome + " Digite a Segunda Nota: ");
            nota2 = float.Parse(Console.ReadLine());
        }

        static float calcularMedia (float media)
        {

            media = (nota1 + nota2) / 2;

            Console.Write("A Sua Média é " + media + "\n");

            if (media >= 7)
                Console.Write("Aprovado");
            else
                Console.Write("Reprovado");
        }
    }
}
